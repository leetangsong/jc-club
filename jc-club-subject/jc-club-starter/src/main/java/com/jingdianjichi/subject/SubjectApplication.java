package com.jingdianjichi.subject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: litangsong
 * @date: 2024/2/28 00:25
 */
@SpringBootApplication
@ComponentScan("com.jingdianjichi")
public class SubjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubjectApplication.class);
    }
}
