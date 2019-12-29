package com.zhouchao.config;

import com.zhouchao.http.message.PropertiesPersonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 2019/12/8
 * zhouchao
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.set(0, new MappingJackson2XmlHttpMessageConverter());
        converters.add(new PropertiesPersonHttpMessageConverter());
    }
}
