package com.donghwan.study.spring.basic.filter;

import com.donghwan.study.spring.filter.log.dto.LogRequestDto;
import com.donghwan.study.spring.filter.log.dto.LogResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

    @PostMapping("/api/v1/study/filter/basic")
    public void studyFilterBasic() {

    }

    @PostMapping("/api/v1/study/filter/log")
    public LogResponseDto studyFilterBasic(@RequestBody LogRequestDto request) {
        return LogResponseDto.from(request);
    }
}
