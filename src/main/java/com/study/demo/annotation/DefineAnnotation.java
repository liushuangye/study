package com.study.demo.annotation;

import com.study.demo.annotation.enums.SexEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.TYPE})/** 标识注解可以用在方法和类上 */
@Retention(RetentionPolicy.RUNTIME)/** 标识注解在运行时仍然有效 */
public @interface DefineAnnotation {
    /**
     * String 是参数类型，name是参数名,每个参数都必须赋值，如果给出了default，则使用注解时可以不进行赋值; eg:@DefineAnnotation(name="张三")
     * 如果参数名只有value 则 则使用时可以将 @A(value="xxx")简写为@A("xxx)
     * 参数类型可以是基础数据类型，class，String，enum
     */
    String value() default "";
    String name();
    int id();
    SexEnum sex();
}
