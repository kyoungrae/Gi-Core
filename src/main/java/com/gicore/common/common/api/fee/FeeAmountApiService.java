package com.gicore.common.common.api.fee;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gicore.common.auth.AuthenticationService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@RequiredArgsConstructor
public class FeeAmountApiService {

    public final RestTemplate restTemplate;
    public final AuthenticationService authenticationService;

    public List<Map<String,Object>> find(Map<String,Object> param, HttpServletRequest request) throws Exception{
        List<Map<String,Object>> resultList = new ArrayList<>();
        String url = "http://localhost:8080/fee/master/feeMaster/find";
        try {
            Cookie[] cookies  = request.getCookies();
            Optional<Cookie> optionalCookie = Arrays.stream(cookies).filter(cookie -> "Authorization".equals(cookie.getName())).findFirst();
            String jwt = optionalCookie.get().getValue();

            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");
            headers.set("Cookie", "Authorization=" + jwt);

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(param, headers);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            List<Map<String, Object>> responseList = objectMapper.readValue(response.getBody(), List.class);
            resultList.addAll(responseList);
        } catch (HttpClientErrorException e) {
            System.out.println("HTTP Status: " + e.getStatusCode());
            System.out.println("Response Body: " + e.getResponseBodyAsString());
            throw new Exception("HTTP error: " + e.getStatusCode() + " " + e.getResponseBodyAsString(), e);
        }
        return resultList;
    }
}
