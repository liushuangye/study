package com.design.observer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.SpringBootMainClassApplication.class)
@WebAppConfiguration
public class MyEventTest {
    @Autowired
    MyService myService;

    @Test
    public void testEvent(){
        myService.deal();
    }
}