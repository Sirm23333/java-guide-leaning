package com.gof.create.singleton;

/**
 * DLC懒汉式单例
 */
public class LazySingleton {
    private static volatile LazySingleton lazySingleton;

    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if(lazySingleton == null){
            synchronized (LazySingleton.class){
                if(lazySingleton == null){
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }

}
