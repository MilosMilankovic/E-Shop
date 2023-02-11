package com.eshop.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
@Slf4j
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        // http
        HttpMessageConverter converter = new StringHttpMessageConverter();
        converters.add(converter);
        log.info("HttpMessageConverter added");

        // string
        converter = new FormHttpMessageConverter();
        converters.add(converter);
        log.info("FormHttpMessageConverter added");

        // json
        converter = new MappingJackson2HttpMessageConverter();
        converters.add(converter);
        log.info("MappingJackson2HttpMessageConverter added");

    }
}
