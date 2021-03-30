package com.ssm.leaning.proxy.jdkpro;

public class Student implements People{
    @Override
    public void say() {
        System.out.println("Student say...");
    }
}
