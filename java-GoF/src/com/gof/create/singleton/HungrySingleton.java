package com.gof.create.singleton;

/**
 * 饿汉式单例
 */
public class HungrySingleton {

    private static HungrySingleton hungrySingleton = new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }

}
