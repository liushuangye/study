package com.study.design.decorator;

public class AComponentDecorator extends ComponentDecorator{
    public AComponentDecorator(IComponent iComponent) {
        super(iComponent);
    }
    public void operation() {
        iComponent.operation();
        System.out.print(" AAA ");
    }
}
