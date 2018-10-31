package com.cn.MyAnnotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/**
 * Created by Administrator on 2018\10\31 0031.
 *
 * TYPE_PARAMETER  新类型
 */
@Repeatable(MyAnnotations.class)//重复注解--指定容器类
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)//生命周期
public @interface MyAnnotation {

    String value() default "wpw";
}
