package com.gicore.common.common.file;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
@RequiredArgsConstructor
public class FileManagerService extends FileProcessManager {
    private final CommonFileMapper commonFileMapper;
    private final String applicationFileName = "application.properties";
    public List<Map<String,Object>> fileSearch(Map<String,Object> param) throws Exception{
        return commonFileMapper.COMMON_FILE_SELECT(param);
    }
    public void fileCreate(Map<String , Object> map) throws Exception{
        String folderName = (String) map.get("folder_name");
        String fileName = (String) map.get("file_name");
        String fileContent = (String) map.get("file_content");
        String fileExtension = (String) map.get("file_extension");

        createFile(folderName, fileName, fileContent, fileExtension);
    }
    public List<Map<String ,Object>> fileUpload(String file_description, String folder_name, String uuid, MultipartFile[] files)throws Exception{
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String uid = (uuid == null || uuid.isEmpty()) ? String.valueOf(UUID.randomUUID()) : uuid;
        String userId = authentication.getName();
        String fileDescription = "";
        if(null != file_description || !file_description.isEmpty()){
            fileDescription = file_description;
        }

        List<Map<String,Object>> result = uploadFile(folder_name,files);
        for(Map<String, Object> list : result){
            list.put("file_uuid",uid);
            list.put("file_description",fileDescription);
            list.put("system_create_userid",userId);
        }
        if(uuid == null){
            var commonFile = CommonFile.builder()
                    .uuid(uid)
                    .file_description(fileDescription)
                    .system_create_userid(userId)
                    .build();
            commonFileMapper.COMMON_FILE_INSERT(commonFile);
        }

        return result;
    }
    public void fileDownload(List<Map<String,Object>> params, HttpServletResponse response) throws Exception{
        for(Map<String ,Object> param : params){
            Map<String ,Object> paramMap = new HashMap<>();
            System.out.println(param.get("file_name"));
            paramMap = param;
            downloadFile(paramMap , response);
        }
    }
    public void zipFileDownload(List<Map<String,Object>> params, HttpServletResponse response) throws Exception{
        String zipFileName = (String) params.get(0).get("file_zip_file_name");
        downloadZipFile(downloadZipFileList(params),response,zipFileName);
    }
    public String getImage(Map<String,Object> request) throws MalformedURLException {
        String baseUrl = (String) request.get("BASE_URL");
        String base_path = (String) request.get("file_path");
        String fileId = (String) request.get("file_id");
        // 파일 존재 여부 확인
        Path filePath = Paths.get(base_path, fileId);
        if (!Files.exists(filePath) || !Files.isRegularFile(filePath)) {
            return ""; // 파일이 없으면 빈 문자열 반환
        }

        return baseUrl +"?fileId="+fileId+"&basePath="+base_path;
    }
}