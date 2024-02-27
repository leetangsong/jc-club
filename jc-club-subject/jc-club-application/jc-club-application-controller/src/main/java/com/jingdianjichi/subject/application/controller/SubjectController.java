package com.jingdianjichi.subject.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: litangsong
 * @date: 2024/2/28 00:34
 */
@RestController
public class SubjectController {

    @GetMapping("/test")
    public String test(){
        return "hello word";
    }

}
