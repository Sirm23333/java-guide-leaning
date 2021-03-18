package com.ssm.leaning.anno;

import java.lang.annotation.*;

// 四个元注解
@Retention(RetentionPolicy.RUNTIME) // 当前注解生效范围
@Target(ElementType.FIELD) // 注解作用范围
@Documented // 文档注释
@Inherited // 有继承关系
public @interface  Autowired {
}
