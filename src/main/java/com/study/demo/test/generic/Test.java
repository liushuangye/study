package com.study.demo.test.generic;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<? extends Person> listExtend = new ArrayList();
        List<? super Person> listSuper = new ArrayList();

        List<GrandPerson> listGrandPerson = new ArrayList();
        List<Person> listPerson = new ArrayList();
        List<Child> listChild = new ArrayList();
        /**
         * 集合指定上界
         * 因为编译器不知道是什么类型,所以不能更再添加数据
         */
        //listExtend = listGrandPerson;//error 不能比Person还大
        listExtend = listPerson;
        //listExtend.add(new Child());//error 限定为extends则不能add数据,因为无法判断通配符?是Person的多少层子级，存在Child赋值给GrandChild的可能
        Person person = listPerson.get(0);//Person是上界，所以用Person来接是安全的
        /**
         *  集合指定下界
         *  因为编译器不知道是什么类型,所以只能放作为下界的类型及其子类型
         *  同时取的时候只能放在Object
         */
        //listSuper = listChild;//error 不能比Person还小
        listSuper = listGrandPerson;
        //listSuper.add(new GrandPerson());
        listSuper.add(new Child());
        Object object = listSuper.get(0);//，所以只能用Object来接收

    }

}

class GrandPerson { }
class Person extends GrandPerson { }
class Child extends Person { }
class GrandChild extends Child { }
