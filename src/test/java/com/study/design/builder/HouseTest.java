package com.study.design.builder;

import org.junit.jupiter.api.Test;

class BuilderTest {
    @Test
    public void test(){
        House.HouseBuilder houseBuilder = new House.HouseBuilder();
        House house = houseBuilder.appendName("豪华别墅")
                .appendArea("中国")
                .appendFloor("3层")
                .appendStyle("欧式")
                .build();
        System.out.println(house.getName());
        System.out.println(house.getArea());
        System.out.println(house.getFloor());
        System.out.println(house.getStyle());
    }
}