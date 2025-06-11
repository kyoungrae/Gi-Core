package com.gicore.common.common.api.open;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class HolidayApiService {
    public final RestTemplate restTemplate;

    HolidayApiService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    public List<Map<String,Object>> searchHoliday(Map<String,Object> param) throws Exception{
        List<Map<String,Object>> resultList = new ArrayList<>();
        String YEAR = param.get("year").toString();
        String NUMOFROWS = "100";
        String KEY = "upM4eIzJDLRKUoXAemVRGZPAc0169zQ7YEmY6DxW1KCqi30hsnEDxjPjWT629RyETfT8haxrKzVb7KfAThHXEw==";
        String url = "http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getHoliDeInfo?"
                +"solYear="+YEAR+"&ServiceKey="+KEY + "&numOfRows=" + NUMOFROWS;
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", "application/json");

            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> responseMap = objectMapper.readValue(response.getBody(), Map.class);
            resultList.add(responseMap);

        }catch(Exception e){
            throw new Exception(e);
        }
        return resultList;
    }
}
