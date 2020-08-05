package com.example.polls.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.DispatcherType;

/**
 * 跨源请求
 */
@Slf4j
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final long MAX_AGE_SECS = 3600;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE")
                .maxAge(MAX_AGE_SECS);
    }

//    @Bean
//    public FilterRegistrationBean spaceFilter() {
//        FilterRegistrationBean filer = new FilterRegistrationBean();
//        filer.setFilter(new SpaceFilter());
//        filer.addUrlPatterns("/*");
//        filer.setName("SpaceFilter");
//        filer.setDispatcherTypes(DispatcherType.REQUEST);
//        return filer;
//    }
}
