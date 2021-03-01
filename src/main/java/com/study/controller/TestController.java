package com.study.controller;

import com.study.entity.TestEntity;
import com.study.mapper.TestEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    TestEntityMapper testEntityMapper;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping(path = "test1")
    public TestEntity test1(){
        TestEntity testEntity;
        testEntity = testEntityMapper.getById(1);
        return testEntity;
    }
    @GetMapping(path = "test2")
    public String test2(){
        String str = restTemplate.getForObject("http://127.0.0.1:8080/test/test1", String.class);
        return str;
    }


}
