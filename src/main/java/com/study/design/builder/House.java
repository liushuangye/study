package com.study.design.builder;

public class House {
    private String name;
    private String area;
    private String style;
    private String floor;

    public String getName() {return name;}
    public String getArea() {return area;}
    public String getStyle() {return style;}
    public String getFloor() {return floor;}

    public static class HouseBuilder{
        House house = new House();
        public HouseBuilder appendName(String name){
            house.name = name;
            return this;
        }
        public HouseBuilder appendArea(String area){
            house.area = area;
            return this;
        }
        public HouseBuilder appendStyle(String style){
            house.style = style;
            return this;
        }
        public HouseBuilder appendFloor(String floor){
            house.floor = floor;
            return this;
        }
        public House build(){
            return house;
        }
    }
}
