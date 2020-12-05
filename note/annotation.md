### 三种标准注解
@Override，表示当前的方法定义将覆盖超类中的方法。如果你不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。<br/>
@Deprecated，如果程序员使用了注解为它的元素，那么编译器会发出警告信息。<br/>
@SuppressWarnings，关闭不当的编译器警告信息。在java SE5之前的版本中，也可以使用该注解，不过会被忽略不起作用。<br/>
### 四种元注解
定义注解时，会需要一些元注解（meta-annotation）
##### @Target 
表示该注解用于什么地方，可能的值在枚举类 ElemenetType 中，包括：<br/>
    ElemenetType.CONSTRUCTOR-----------------------------构造器声明 <br/>
    ElemenetType.FIELD ----------------------------------域声明（包括 enum 实例）<br/> 
    ElemenetType.LOCAL_VARIABLE------------------------- 局部变量声明<br/> 
    ElemenetType.METHOD ---------------------------------方法声明 <br/>
    ElemenetType.PACKAGE --------------------------------包声明 <br/>
    ElemenetType.PARAMETER ------------------------------参数声明 <br/>
    ElemenetType.TYPE----------------------------------- 类，接口（包括注解类型）或enum声明 <br/>

##### @Retention 
用来定义该注解在哪一个级别可用，在源代码中（SOURCE）、类文件中（CLASS）或者运行时（RUNTIME）。<br/>
    RetentionPolicy.SOURCE-------------注解将被编译器丢弃 <br/>
    RetentionPolicy.CLASS -------------注解在class文件中可用，但会被VM丢弃 <br/>
    RetentionPolicy.RUNTIME ---------VM将在运行期也保留注释，因此可以通过反射机制读取注解的信息。<br/>
##### @Documented 
将此注解包含在 javadoc 中 ，它代表着此注解会被javadoc工具提取成文档。在doc文档中的内容会因为此注解的信息内容不同而不同。相当与@see,@param 等。

##### @Inherited 
允许子类继承父类中的注解。eg:此注解作用在了A上，B集成了A那么B上也会带有此注解。
    









