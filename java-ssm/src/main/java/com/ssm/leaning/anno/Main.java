package com.ssm.leaning.anno;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.reflect.Field;
import java.util.stream.Stream;

/**
 * 自定义一个Autowire注解，通过反射注入一个Student对象
 */

public class Main {
    public static void main(String[] args) {
        User user = new User();
        Class<? extends User> aClass = user.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        Stream.of(declaredFields).forEach(field -> {
            field.setAccessible(true);
            if(field.getType() == Student.class){
                try {
                    Object o = field.getType().newInstance();
                    field.set(user,o);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        });
        user.say();
    }


}
