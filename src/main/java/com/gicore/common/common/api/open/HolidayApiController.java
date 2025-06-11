package com.gicore.common.common.api.open;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/open/holiday")
public class HolidayApiController {
    public final HolidayApiService holidayApiService;
    HolidayApiController(HolidayApiService holidayApiService){
        this.holidayApiService = holidayApiService;
    }
    @PostMapping("/search")
    public List<Map<String,Object>> searchHoliday(@RequestBody Map<String,Object> param) throws Exception {
            return holidayApiService.searchHoliday(param);
    }
}
