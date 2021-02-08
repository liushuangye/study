package com.study;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    @Test
    public void fun(){
        List<Person> list = new ArrayList();

        Person person1 = new Person();
        person1.setAge(17);
        person1.setName("小明");

        Person person2 = new Person();
        person2.setAge(20);
        person2.setName("小黑");

        list.add(person1);
        list.add(person2);
        /** 构建一个stream */
        //1.产生一个stream元素为给定值  这里我们给定一个list，stream将list看做一个整体
        Stream.of(list).forEach(i -> System.out.println(i));//[Person{name='小明', age=17}, Person{name='小黑', age=20}]
        //2.产生一个空的stream
        Stream.empty();
        //3.generate产生一个无限流，值有反复调用Supplier函数获取
        Stream.generate(Person::new).limit(10);
        //4.iterate产生一个无限流：给定初值，重复处理初始值获取元素;可以通过limit限制获取多少个元素
        Stream.iterate(1,x->x+1).limit(10).forEach(i -> System.out.println(i));
        //5.Array.stream截取数组指定范围内的数据生成流
        System.out.println("-------Array.stream-------");
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        Arrays.stream(arr,2,5).forEach(i -> System.out.println(i));
        //6.Pattern.compile(rex).splitAsStream(String)从字符串获取流
        System.out.println("-------splitAsStream-------");
        Pattern.compile(",").splitAsStream("a,b,c,d,e").forEach(i -> System.out.println(i));
        //7.Files.lines 从文件获取流(建议使用try with resource来关闭stream)
        System.out.println("-------Files.lines-------");
        try(Stream<String> stream = Files.lines(Paths.get("C:\\Users\\liush\\Desktop\\日语-数量日期.txt"))){
            stream.forEach(i -> System.out.println(i));
        }catch (IOException ex){
            ex.printStackTrace();
        }
        /** 流的内容进行处理 */
        //过滤filter 接收断言(Predicate)型参数
        list.stream()
                .filter(p -> p.getAge() > 18)
                .forEach(person -> System.out.println(person));
        //数据处理map 接收Function型参数
        list.stream().map(person -> {
            person.setName(person.getName()+"（new_name）");
            return person;
        }).forEach(person -> System.out.println(person));

        /** 流的抽取和连接 */
        //1.limit限制取多少个
        Pattern.compile(",").splitAsStream("a,b,c,d,e").limit(3).forEach(i -> System.out.println(i));
        //2.skip跳过前多少个
        Pattern.compile(",").splitAsStream("1,2,3,4,5").skip(3).forEach(i -> System.out.println(i));
        //3.concat连接流
        Stream.concat(Pattern.compile(",").splitAsStream("A,B"),Pattern.compile(",").splitAsStream("C,D"))
                .forEach(i -> System.out.println(i));
        /** 去重与排序*/
        //distinct去重
        Pattern.compile(",").splitAsStream("red,white,blue,red,blue").distinct().forEach(i -> System.out.println(i));
        //sort(Comparator)，如果不给参数则需要被比较的对象本身有比较器
        Pattern.compile(",").splitAsStream("1,22,333,4444,55555").sorted((x,y)->x.length()-y.length()).forEach(i -> System.out.println(i));
    }
    @Test
    public void fun2(){
        /** 各种终止流的操作 */
        Stream<String> stream = Pattern.compile(",").splitAsStream("AB,AC,ARFDB,1,3,5,7,333");
        Optional<String> rt = stream.filter(x -> x.startsWith("A"))
//                .max(String::compareToIgnoreCase);
//                .min(String::compareToIgnoreCase);
                .findFirst();
//                .findAny();//返回任意一个，需要注意的是 数据量少且串行 一般返回第一个，并行则结果不一定
        System.out.println(rt.orElse("@"));

        Stream<String> stream2 = Pattern.compile(",").splitAsStream("AB,AC,ARFDB,1,3,5,7,333");
        boolean flg = stream2
//                .anyMatch(x->x.startsWith("A"));//任意符合
//                .allMatch(x->x.startsWith("A"));//全部符合
                .noneMatch(x->x.startsWith("A"));//没有符合
        System.out.println(flg);

    }
}
class Person{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
