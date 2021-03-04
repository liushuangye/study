package com.study.design.decorator;

public class ComponentDecorator implements IComponent{
    protected IComponent iComponent;
    public ComponentDecorator(IComponent iComponent){
        this.iComponent = iComponent;
    }
    @Override
    public void operation() {
        iComponent.operation();
    }
}
