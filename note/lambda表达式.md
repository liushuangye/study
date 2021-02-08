## 各种语法实例
```java
package com.study;

import org.junit.jupiter.api.Test;

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

```

## 四大内置函数式接口
Consumer 消费型接口 消费对象<br/>
    void accept(T t);<br/>
Supplier 供给型接口 生成对象<br/>
    T get();<br/>
Function<R,T> 函数型接口 指定特定功能<br/>
    R apply(T t);<br/>
Predicate 断言型接口 进行条件判断<br/>
    boolean test(T t);<br/>
这些接口上都有@FunctionalInterface注解来标识这个是一个函数式接口，一般作为其他方法的参数使用
```
@Test
public void lambdaInnerFun(){
    Integer rt = functionTR("2333", str -> Integer.valueOf(str).intValue());
    System.out.println(rt);
}
public Integer functionTR(String str, Function<String,Integer> funTR){//这里funTR接收一个字符串返回一个整型
    return funTR.apply(str);
}
```

## 复合lambda表达式
####比较器复合
```
//  原有基础上逆序
apples.sort(Comparator.comparing(Apple::getWeight).reversed());
//  原有基础上逆序,一样重时 再按颜色排序
apples.sort(Comparator.comparing(Apple::getWeight).reversed()
       .thenComparing(Apple::getColor));
```
####谓词复合
```
Predicate<Apple> predicate = (Apple a)->a.getWeight()>100;
Predicate<Apple> predicate2 = (Apple a)->a.getColor().equals("yellow");
// 非
Predicate<Apple> notRedApple = predicate.negate();
// 与
Predicate<Apple> andPredicate = notRedApple.and(predicate2);

apples.stream().filter(notRedApple);
apples.stream().filter(andPredicate);
```
####函数复合
```
Function<Integer, Integer> f = x -> x + 1;
Function<Integer, Integer> g = x -> x * 2;
Function<Integer, Integer> h = f.andThen(g);
int result = h.apply(1); 
// 结果返回4
```