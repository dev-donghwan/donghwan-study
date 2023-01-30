package com.donghwan.study.spring.filter;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

    @PostMapping("/api/v1/study/filter/basic")
    public void studyFilterBasic() {

    }
}
