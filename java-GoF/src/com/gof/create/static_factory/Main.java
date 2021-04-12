package com.gof.create.static_factory;

/**
 * 简单工厂模式，也叫静态工厂模式
 * 优点：
 *      1.工厂类负责对象的创建，实现了对象创建和使用的分离
 *      2.不用修改业务代码，只需修改工厂类的代码，就可以达到管理对象，一定程度上解耦
 * 缺点：
 *      1.工厂类职责过重，若出现问题，整个系统瘫痪
 *      2.需要修改工厂类的代码，一定程度上违反开闭原则
 */
public class Main {
    public static void main(String[] args) {
        Person teacher = Factory.getPerson("teacher");
        Person student = Factory.getPerson("student");
        teacher.say();
        student.say();
    }
}
