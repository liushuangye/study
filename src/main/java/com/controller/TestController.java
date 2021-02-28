package com.controller;

import com.entity.TestEntity;
import com.mapper.TestEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    TestEntityMapper testEntityMapper;
    @GetMapping(path = "str")
    public TestEntity test(){
        TestEntity testEntity;
        testEntity = testEntityMapper.getById(1);
        return testEntity;
    }
}
