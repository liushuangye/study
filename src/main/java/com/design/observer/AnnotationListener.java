package com.design.observer;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AnnotationListener {
    @EventListener
    public void annotationListener1(MyEvent event) {
        System.out.println("AnnotationListener1");
    }
    @EventListener({MyEvent.class,OtherEvent.class})
    public void annotationListener2(ApplicationEvent event) {
        System.out.println("AnnotationListener2");
    }
}
