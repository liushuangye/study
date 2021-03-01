package com.study.design.observer;

import org.springframework.context.ApplicationEvent;

public class OtherEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public OtherEvent(Object source) {
        super(source);
    }
}
