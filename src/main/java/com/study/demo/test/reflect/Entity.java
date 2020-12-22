package com.study.demo.test.reflect;

public class Entity {
    public Entity() {}
    public Entity(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void publicMethod(){System.out.println("publicMethod");}
    private void privateMethod(){System.out.println("privateMethod");}
    public static void publicStaticMethod(){System.out.println("publicStaticMethod");}
    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                '}';
    }
}
