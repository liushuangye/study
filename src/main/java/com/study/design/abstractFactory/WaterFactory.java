package com.study.design.abstractFactory;

public class WaterFactory extends AbstractFacotry{
    @Override
    public IMoveable getMoveable() {
        return new WaterPlane();
    }

    @Override
    public IEatable getEatable() {
        return new WaterBread();
    }
}
