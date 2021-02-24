```java
package com.study;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
    /** 各种终止流的操作 */
    @Test
    public void fun2(){
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


        //3.
    }
    /** 收集结果 */
    @Test
    public void fun3(){
        Stream<String> stream = Pattern.compile(",").splitAsStream("AB,AC,ARFDB,1,3,5,7,333");
        stream = Pattern.compile(",").splitAsStream("AB,AC,AD,1,3,5,7");
        //1.通过iterator来收集，返回一个迭代器
        Iterator<String> iterator = stream.iterator();
        //2.通过forEach来，收集并将syso等函数应用于每个元素
        stream.forEach(i -> System.out.println(i));
        //3.通过toArray()，返回数组
        Object[] objects = stream.toArray();//返回Obj的数组
        Person[] strings = stream.toArray(Person[]::new);//要指定返回数组的类型需要传递到数组构造器中
        //4.通过collect(),该方法返回一个实现了Collector接口的实例
        List<String> collectList = stream.collect(Collectors.toList());
        Set<String> collectSet = stream.collect(Collectors.toSet());
        Person[] personArr = {new Person(),new Person()};
        List<Person> personList = Arrays.stream(personArr).collect(Collectors.toList());//这里返回的是List<Person> , 因为 .stream(personArr) 返回的是Stream<Person>
        TreeSet<String> collect = stream.collect(Collectors.toCollection(TreeSet::new));//通过构造器可以返回指定类型的集合
        //5.使用summarizing(Int|Long|Double),对数据类型的流进行归总,SummaryStatistics对象包含 count max min average 等信息
        int[] intArr = {1,2,3,4,5,6};
        IntSummaryStatistics intSummaryStatistics = Arrays.stream(intArr).summaryStatistics();
        intSummaryStatistics.getAverage();
        intSummaryStatistics.getMax();
        //6.将流中的元素拼接起来
        String str = stream.collect(Collectors.joining(","));//AB,AC,AD,1,3,5,7   joining还可指定前后缀，前后缀是在结果串的前后，而非每个元素前后

    }
    /** 收集结果-映射 */
    @Test
    public void fun4(){
        Person person1 = new Person();
        person1.setId(Long.valueOf(1));
        person1.setName("小一");
        person1.setAge(17);
        Person person2 = new Person();
        person2.setId(Long.valueOf(2));
        person2.setName("小二");
        person2.setAge(17);
        Person person3 = new Person();
        person3.setId(Long.valueOf(2));
        person3.setName("小三");
        person3.setAge(18);
        Stream<Person> stream = Stream.of(person1, person2, person3);
        //1.给定两个Function确定key和value，key有重的则会报错
        Map<Long, String> map = stream.collect(Collectors.toMap(Person::getId, Person::getName));
        System.out.println(map);

        stream = Stream.of(person1, person2, person3);
        //2.第三个参数可以给定key出现重复时值得处理方式
        Map<Long, String> map1 = stream.collect(Collectors.toMap(Person::getId, Person::getName,(a,b)->a+b));
        System.out.println(map1);

        stream = Stream.of(person1, person2, person3);
        //3.第四个参数可以给定返回的类型
        LinkedHashMap<Long, String> map2 = stream.collect(Collectors.toMap(Person::getId, Person::getName, (a, b) -> a + b, LinkedHashMap::new));
        System.out.println(map2);


    }
    /** 收集结果-分组 */
    @Test
    public void fun5(){
        Person person1 = new Person();
        person1.setId(Long.valueOf(1));
        person1.setName("小一");
        person1.setAge(17);
        Person person2 = new Person();
        person2.setId(Long.valueOf(2));
        person2.setName("小二");
        person2.setAge(17);
        Person person3 = new Person();
        person3.setId(Long.valueOf(3));
        person3.setName("大三");
        person3.setAge(19);
        Person person4 = new Person();
        person4.setId(Long.valueOf(4));
        person4.setName("大四");
        person4.setAge(19);
        Stream<Person> stream = Stream.of(person1, person2, person3, person4);
        //1.partitioningBy断言分组 结果true/false两组
        Map<Boolean, List<Person>> map = stream.collect(Collectors.partitioningBy(p -> {
            return p.getAge() > 18;
        }));
        System.out.println("结果为真:"+map.get(true));
        System.out.println("结果为假:"+map.get(false));
        //2.groupingBy 按指定规则分组
        stream = Stream.of(person1, person2, person3, person4);
        Map<Integer, List<Person>> map1 = stream.collect(Collectors.groupingBy(Person::getAge));//按照某属性进行分组
        System.out.println("按年龄分组:"+map1.toString());

        stream = Stream.of(person1, person2, person3, person4);
        Map<String, List<Person>> group = stream.collect(Collectors.groupingBy(item -> {
            if (item.getName().startsWith("小")) {
                return "小";
            } else if (item.getName().startsWith("大")) {
                return "大";
            } else {
                return "其他";
            }
        }));//指定分组规则
        System.out.println("按年龄分组:"+group.toString());
        //3.分组结果是一个列表，可以进行下游处理
        stream = Stream.of(person1, person2, person3, person4);
        //对每组元素进行计数，也可传入Collectors.summingLong(Person::getId) 或 maxBy/minBy等对列表进行求和等处理
        Map<Integer, Long> after = stream.collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
        System.out.println("按年龄分组:"+after.toString());
    }

    /** 约简 */
    @Test
    public void fun6(){
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        IntStream stream = Arrays.stream(arr);
        //1.一个参数Function，对所有元素进行该操作
        OptionalInt op = stream.reduce((x, y) -> x + y);
        System.out.println(op.orElse(-1));

        stream = Arrays.stream(arr);
        //2.两个参数：第一个参数为运算的初始值，为空则返回该值，这样可以不必处理Optional对象了
        int reduce = stream.reduce(100, (x, y) -> x + y);
        System.out.println(reduce);
        //3.针对并行处理还可以提供第三个参数运算，对结果应用于各个结果。


        stream = Arrays.stream(arr);
        //reduce可以方便地对符合条件的元素进行处理，如 统计出所有的偶数的和
        int reduce1 = stream.reduce(0, (x, y) -> {
            return y % 2 == 0 ? x + y : x;
        });
        System.out.println(reduce1);
    }

}
class Person{
    private Long id;
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

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

```