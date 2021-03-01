package com.study.design.template;

public abstract class AbstractTemplate {
    public final void fun(){
        part1();
        part2();
        part3();

    }

    void part1() {System.out.println("part1");}

    abstract void part2();

    void part3() {System.out.println("part3");}
}
