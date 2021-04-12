package com.gof.create.singleton;

public class LazySingletonJVM {

    // 加载外部类的时候，不会加载内部类和内部静态类
    // 加载内部静态类时，会加载外部类
    private static class LazySingletonJVMHandler{
        public final static LazySingletonJVM lazySingletonJVM = new LazySingletonJVM();
    }
    public static LazySingletonJVM getInstance(){
        return LazySingletonJVMHandler.lazySingletonJVM;
    }
}
