package com.study.demo.test.jiekou;

public class InnerClassTest {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.setName("外部类");
        outer.say();//我的名字是：外部类
        Outer.Inner inner = outer.new Inner();//创建内部类实例
        inner.innerSay();//我是外部类的内部类
    }
}
class Outer {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void say(){
        System.out.println("我的名字是："+name);
    }
    class Inner{
        public void innerSay(){
            System.out.println("我是"+name+"的内部类");
        }
    }
}
