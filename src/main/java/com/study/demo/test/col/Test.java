package com.study.demo.test.col;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        Iterator iterator = list.iterator();
        iterator.next();
        iterator.next();
        iterator.remove();
        for (Object item:list) {
            System.out.println(item);
        }
    }
}
