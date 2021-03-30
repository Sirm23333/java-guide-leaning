package com.ssm.leaning.proxy.cglibpro;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class StudentCglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] arg, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before student say");
        methodProxy.invokeSuper(obj,arg);
        System.out.println("After student say");
        return obj;
    }
}
