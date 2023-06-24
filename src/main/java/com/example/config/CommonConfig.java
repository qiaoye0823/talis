package com.example.config;

import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CommonConfig {
    @Bean  // 将当前方法的返回值对象交给IOC容器管理，成为IOC容器bean
    public SAXReader saxReader(){
        return new SAXReader();
    }
}
