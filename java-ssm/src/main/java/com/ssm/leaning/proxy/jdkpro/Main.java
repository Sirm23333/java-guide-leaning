package com.ssm.leaning.proxy.jdkpro;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        StudentInvocationHandler handler = new StudentInvocationHandler(student);
        People proxyPeople = (People) Proxy.newProxyInstance(
                student.getClass().getClassLoader(),
                student.getClass().getInterfaces(),
                handler);
        proxyPeople.say();

    }
}
