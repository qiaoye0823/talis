package com.example;

import org.dom4j.io.SAXReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import javax.xml.transform.sax.SAXResult;

@ServletComponentScan
@SpringBootApplication
public class TliasApplication {

    public static void main(String[] args) {
        SpringApplication.run(TliasApplication.class, args);
    }

    // 声明第三方bean


}
