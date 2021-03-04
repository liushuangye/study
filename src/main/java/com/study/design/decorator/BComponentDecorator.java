package com.study.design.decorator;

public class BComponentDecorator extends ComponentDecorator{
    public BComponentDecorator(IComponent iComponent) {
        super(iComponent);
    }
    public void operation() {
        iComponent.operation();
        System.out.print(" BBB ");
    }
}
