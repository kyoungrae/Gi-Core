package com.gicore.common.common.file;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Component
public class FileProcessManager implements FileProcessManagerImpl {
    private final String applicationFileName = "application.properties";
    private final String directory;
    private final String fileSize;
    private final String fileUnit;
    private final long MAX_FILE_SIZE;

    public FileProcessManager() {
        // 프로퍼티 로드
        Properties properties = loadProperties(applicationFileName);
        this.directory = properties.getProperty("com.vims.common.file.directory.path");
        this.fileSize = properties.getProperty("com.vims.common.file.max.size");
        this.fileUnit = properties.getProperty("com.vims.common.file.max.size.unit");
        this.MAX_FILE_SIZE = fileSizeDefinition(fileSize, fileUnit);
    }

    @Override
    public List<Map<String, Object>> searchfile(Map<String, Object> param) throws Exception {
        return null;
    }

    @Override
    public void createFile(String folder_name, String file_name, String file_content ,String ex){
        String fileName = file_name;
        String fileContent = file_content;
        String extensions = ex;
        String folderName = folder_name;

        if(fileContent.getBytes().length > MAX_FILE_SIZE){
            System.err.println("File size exceeds the limit");
            return;
        }

        String directotyPath = directory;
        if(!folderName.isEmpty()){
            directotyPath = directory +"/"+folderName;
        }

        if(!isValidDirectory(directotyPath)){
            try {
                Files.createDirectories(Paths.get(directotyPath));
                System.out.println("Invalid directory path");
                System.out.println("Directory created successfully");
            } catch (IOException ioException) {
                System.err.println("Failed to create directory");
                System.err.println(ioException.getMessage());
                return;
            }
        }
        String filePath = "";
        if(directotyPath.endsWith("/")){
            filePath = directotyPath + fileName + extensions;
        }else{
            filePath = directotyPath +"/"+ fileName + extensions;
        }

        try (FileOutputStream outputStream = new FileOutputStream(filePath.toString())) {
            outputStream.write(fileContent.getBytes());
            System.out.println(filePath + ": File successfully created.");
        } catch (IOException e) {
            System.err.println("Error occurred while creating file: " + e.getMessage());
        }

    }

    @Override
    public List<Map<String ,Object>> uploadFile(String folder_name,MultipartFile[] files) throws IOException {
        String directoryPath = null;
        String folderName = folder_name;
        List<Map<String,Object>> result = new ArrayList<>();

        if (files != null && files.length > 0) {
            if(!folderName.isEmpty()){
                if(directory.endsWith("/")){
                    directoryPath = directory + folderName;
                }else{
                    directoryPath = directory +"/"+ folderName;
                }
            }else{
                directoryPath = directory;
            }

            if(!isValidDirectory(directoryPath)){
                try {
                    Files.createDirectories(Paths.get(directoryPath));
                    System.out.println("Invalid directory path");
                    System.out.println("Directory created successfully");
                } catch (IOException ioException) {
                    System.err.println(ioException.getMessage());
                    throw new IOException("Failed to create directory");
                }
            }
            int index = 0;
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    UUID fileUUID = UUID.randomUUID();
                    Map<String ,Object> map = new HashMap<>();
                    map.put("file_path",directoryPath);
                    map.put("file_id",String.valueOf(fileUUID));
                    result.add(map);

                    List<String> list = Arrays.asList(Objects.requireNonNull(file.getOriginalFilename()).split("\\."));
                    String lastItem = list.stream().reduce((first, second) -> second).orElse(null);

                    File uploadFile = new File(directoryPath + File.separator + fileUUID+"."+lastItem);
                    file.transferTo(uploadFile);
                    System.out.println("fileUUID::"+fileUUID);
                    System.out.println(uploadFile);
                }
                index++;
            }
            System.out.println("All files uploaded successfully");
        } else {
            System.out.println("No files uploaded");
        }
        return result;
    }

    @Override
    public void downloadFile(Map<String, Object> param , HttpServletResponse response) throws IOException {
        String filePath  = (String) param.get("file_path");
        String fileName = (String) param.get("file_name");
        String downloadFile = filePath + "/" + fileName;
        File file = new File(downloadFile);
        if (file.exists()) {
            try (InputStream inputStream = new FileInputStream(file)) {
                response.setHeader("Content-Disposition", "attachment; filename="+fileName);
                response.setContentType("application/octet-stream; charset=utf-8");
                IOUtils.copy(inputStream, response.getOutputStream());
                response.flushBuffer();
                System.out.println("downloadFile:"+downloadFile);
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    public List<File> downloadZipFileList(List<Map<String,Object>> params) throws IOException {
        List<File> fileList = new LinkedList<>();
        for(Map<String,Object> param : params){
            String filePath = (String) param.get("file_path");
            String fileName = (String) param.get("file_name");
            String fileOriginalName = (String) param.get("file_original_name");
            Path sourcePath = Paths.get(filePath, fileName);
            Path targetPath = Paths.get(filePath, fileOriginalName);

            try {
                if (Files.exists(sourcePath)) {
                    Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                    fileList.add(targetPath.toFile());
                    System.out.println("Add FileList Success");

                } else {
                    throw new IOException("File not Exist");
                }
            } catch (IOException e) {
                throw new IOException(e.getMessage());
            }
        }
        return fileList;
    }

    @Override
    public void downloadZipFile(List<File> param, HttpServletResponse response , String zip_file_name) throws Exception {
        String zipFileName = zip_file_name + ".zip";
        String encodedFileName = URLEncoder.encode(zipFileName , StandardCharsets.UTF_8).replaceAll("\\+", "%20");

        response.setHeader("Content-Disposition", "attachment; filename=" + encodedFileName );
        response.setContentType("application/zip");
        response.setStatus(HttpServletResponse.SC_OK);

        try (ZipOutputStream zipOut = new ZipOutputStream(response.getOutputStream())) {
            for (File file : param) {
                zipOut.putNextEntry(new ZipEntry(file.getName()));
                try (FileInputStream fis = new FileInputStream(file)) {
                    StreamUtils.copy(fis, zipOut);
                }
                zipOut.closeEntry();
            }
            deleteFiles(param);
        }
    }
    public void deleteFiles(List<File> fileList) throws IOException {
        for (File file : fileList) {
            Files.deleteIfExists(file.toPath());
        }
    }
    @Override
    public boolean isValidDirectory(String directory) {
        Path path = Paths.get(directory);
        return Files.exists(path) && Files.isDirectory(path);
    }

    public Long fileSizeDefinition(String size , String unit ) {
        long result = 0L;
        try {
            if (unit.equalsIgnoreCase("GB")) {
                result = Long.parseLong(size) * 1024 * 1024 * 1024;
            } else if (unit.equalsIgnoreCase("MB")) {
                result = Long.parseLong(size) * 1024 * 1024;
            } else if (unit.equalsIgnoreCase("KB")) {
                result = Long.parseLong(size) * 1024;
            } else {
                System.err.println("Invalid unit: " + unit);
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid size: " + size);
            System.err.println(e.getMessage());
        }
        return result;
    }
    public String loadProperty(String propertyFileName, String propertyName) {
        try{
            Properties properties = new Properties();
            properties.load(new FileInputStream(propertyFileName));
            return properties.getProperty(propertyName);
        }catch(IOException e){
            System.err.println(e.getMessage());
            return null;
        }
    }
    private Properties loadProperties(String propertyFileName) {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(propertyFileName)) {
            if (input == null) {
                System.err.println("Sorry, unable to find " + propertyFileName);
                return properties; // 빈 프로퍼티 반환
            }
            properties.load(input);
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
        return properties;
    }
}