package com.study;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class LambdaTest {
    @Test
    public void lambdaTestFun(){
        Test1 test1 = () -> System.out.println("无参无返回值,不写大括号");
        Test1 test11 = () -> {System.out.println("无参无返回值,写大括号,最后要分号结尾");};
        test1.fun();
        test11.fun();
        System.out.println("----------------------------------------------------------");
        Test2 test2 = (str) -> System.out.println(str);
        test2.fun("单参数无返回值");
        System.out.println("----------------------------------------------------------");
        Test3 test3 = (str,i) -> System.out.println("para1:"+str+",para2:"+i);
        test3.fun("lambda可以不指定参数类型，由上下文推断：参数1",2);
        System.out.println("----------------------------------------------------------");
        Test4 test4 = (str) -> {return str;};
        System.out.println(test4.fun("有参有返回值"));
        System.out.println("----------------------------------------------------------");

    }
    @Test
    public void lambdaInnerFun(){
        Integer rt = functionTR("2333", str -> Integer.valueOf(str).intValue());
        System.out.println(rt);
    }
    public Integer functionTR(String str, Function<String,Integer> funTR){//这里funTR接收一个字符串返回一个整型
        return funTR.apply(str);
    }

}
/** 无参无返回值 */
interface Test1{
    void fun();
}
/** 单参无返回值 */
interface Test2{
    void fun(String str);
}
/** 多参无返回值 */
interface Test3{
    void fun(String str,Integer i);
}
/** 有参有返回值 */
interface Test4{
    String fun(String str);
}
