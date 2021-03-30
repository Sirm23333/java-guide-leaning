package com.ssm.leaning.proxy.cglibpro;

import org.springframework.cglib.proxy.Enhancer;

public class Main {
    public static void main(String[] args) {
        StudentCglibProxy proxy = new StudentCglibProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Student.class);
        enhancer.setCallback(proxy);
        Student student =(Student) enhancer.create();
        student.say();
    }
}
