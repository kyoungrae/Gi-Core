package com.gicore.common.common.file;

import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface FileProcessManagerImpl {
    List<Map<String,Object>> searchfile(Map<String,Object> param) throws Exception;
    void createFile(String f,String t , String v, String s) throws Exception;
    List<Map<String ,Object>> uploadFile(String folder_name, MultipartFile[] files) throws Exception;
    void downloadFile(Map<String,Object> param, HttpServletResponse response) throws Exception;
    List<File> downloadZipFileList(List<Map<String,Object>> param) throws Exception;
    void deleteFiles(List<File> fileList) throws Exception;
    void downloadZipFile(List<File> param, HttpServletResponse response,String zip_file_name) throws Exception;
    boolean isValidDirectory(String str) throws Exception;
    String loadProperty(String propertyFileName,String propertyName) throws IOException;
    Long fileSizeDefinition(String size , String unit );
}