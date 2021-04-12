package com.gof.create.singleton;

/**
 * 利用枚举创建懒汉式单例
 */
public enum LazySingletonEnum {
    INSTANCE;
    public static LazySingletonEnum getInstance(){
        return INSTANCE;
    }
}
