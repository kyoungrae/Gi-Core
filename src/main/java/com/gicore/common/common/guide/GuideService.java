package com.gicore.common.common.guide;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;

@Service
public class GuideService {
    protected String readFile(Map<String, Object> param) throws Exception {
        String filePath = (String) param.get("filePath");
        StringBuilder result = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.replaceAll("<", "&lt;")
                            .replaceAll(">", "&gt;")
                            .replaceAll("\"", "&quot;")
                            .replaceAll("'", "&#039;");
                result.append(line).append(System.lineSeparator());
            }
        } catch (Exception e) {
            throw new Exception("File reading error", e);
        }

        return result.toString();
    }
}
