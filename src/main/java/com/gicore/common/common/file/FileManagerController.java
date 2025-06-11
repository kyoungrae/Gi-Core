package com.gicore.common.common.file;

import com.gicore.common.util.ApplicationResource;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletResponse;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static org.springframework.core.io.support.PropertiesLoaderUtils.loadProperties;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fileManager")
public class FileManagerController {
    private final FileManagerService fileManagerService;
    private final String BASE_URL = "http://localhost:8080/fileManager/images/";
    private final String BASE_PATH = "C:/Temp/vims/file/userImgFolder/";

    @PostMapping("/create")
    public void createFile(@RequestBody Map<String ,Object> param) throws Exception {
        fileManagerService.fileCreate(param);
    }
    @PostMapping("/upload")
    public List<Map<String ,Object>> uploadFile(@RequestParam("file_description") String file_description, @RequestParam("folder_name") String folder_name, @RequestParam(value = "uuid", required = false) String uuid, @RequestParam("files") MultipartFile[] files) throws Exception {
        List<Map<String ,Object>> map = fileManagerService.fileUpload(file_description, folder_name, uuid, files);
        return map;
    }
    @PostMapping("/search")
    public List<Map<String,Object>> searchFile(@RequestBody Map<String,Object> param) throws Exception{
        return fileManagerService.fileSearch(param);
    }

    @PostMapping("/download")
    public void downloadFile(@RequestBody List<Map<String,Object>> param , HttpServletResponse response) throws Exception{
        fileManagerService.fileDownload(param,response);
    }
    @PostMapping("/downloadZipFile")
    public void downloadZipFile(@RequestBody List<Map<String,Object>> param , HttpServletResponse response) throws Exception{
        fileManagerService.zipFileDownload(param,response);
    }
    @PostMapping("/searchImg")
    public String getImage(@RequestBody Map<String,Object> request) throws Exception {
        String baseUrl = ApplicationResource.get("application.properties").get("imgPath").toString();
        request.put("BASE_URL",baseUrl);
        return fileManagerService.getImage(request);
    }
    @GetMapping("/images")
    public Resource serveImage(@RequestParam String fileId, String basePath) throws MalformedURLException {
        Path filePath = Paths.get(basePath, fileId);
        return new UrlResource(filePath.toUri());
    }
}