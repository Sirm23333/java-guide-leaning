package com.ssm.leaning.proxy.jdkpro;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StudentInvocationHandler implements InvocationHandler {
    private Object target;

    public StudentInvocationHandler(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before student say");
        Object invoke = method.invoke(target,args);
        System.out.println("After student say");
        return invoke;
    }
}
