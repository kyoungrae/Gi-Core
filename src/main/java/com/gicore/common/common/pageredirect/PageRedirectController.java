package com.gicore.common.common.pageredirect;

import com.gicore.common.login.LoginController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/common/redirectPage")
public class PageRedirectController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    private final MessageService messageService;
    public PageRedirectController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/redirect")
    @ResponseBody
    public String redirectToNewPage(@RequestParam("url") String param) {
        String resourcePath = "templates/page" + param;
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                return loadErrorPage();
            }
            var content = messageMatcher(new String(inputStream.readAllBytes(), StandardCharsets.UTF_8),"ko");
            System.out.println(content);
            return content;
        } catch (Exception e) {
            logger.error("Error loading page: " + param, e);
            return loadErrorPage();
        }
    }
    private String messageMatcher(String content,String lang){

        Pattern pattern = Pattern.compile("\\[Page\\.Message\\]\\.Message\\.Label\\.Array\\[\"(.*?)\"\\]");
        Matcher matcher = pattern.matcher(content);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String key = matcher.group(1);
            String message = messageService.getMessage(key, lang);
            matcher.appendReplacement(result, message);
        }
        matcher.appendTail(result);

        return result.toString();
    }

    private String loadErrorPage() {
        String errorPagePath = "templates/page/common/404.html";
        try (InputStream errorStream = getClass().getClassLoader().getResourceAsStream(errorPagePath)) {
            if (errorStream == null) {
                logger.error("Error loading 404.html file.");
                return "<div>404 Page Not Found</div>";
            }
            return new String(errorStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            logger.error("Error loading error page.", e);
            return "<div>404 Page Not Found</div>";
        }
    }
}