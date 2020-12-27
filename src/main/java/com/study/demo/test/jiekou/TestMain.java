package com.study.demo.test.jiekou;
import java.util.Arrays;
public class TestMain{
    public static void main(String[] args) {
        String[] arr = {"22","1","333"};
        Arrays.sort(arr,En::sort);
        System.out.println(Arrays.toString(arr));
    }
}
class En{
    public static int sort(String a,String b){
        return a.length()-b.length();
    }
}
