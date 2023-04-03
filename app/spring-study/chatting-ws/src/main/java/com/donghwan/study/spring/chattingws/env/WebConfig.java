package com.donghwan.study.spring.chattingws.env;

import com.donghwan.study.spring.chattingws.common.EnumConvertFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        WebMvcConfigurer.super.addFormatters(registry);
        //ConvertFactory
        registry.addConverterFactory(new EnumConvertFactory());
    }
}
