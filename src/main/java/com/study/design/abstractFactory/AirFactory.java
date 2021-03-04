package com.study.design.abstractFactory;

public class AirFactory extends AbstractFacotry{
    @Override
    public IMoveable getMoveable() {
        return new AirPlane();
    }

    @Override
    public IEatable getEatable() {
        return new AirBread();
    }
}
