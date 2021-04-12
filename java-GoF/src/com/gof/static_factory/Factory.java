package com.gof.static_factory;

public class Factory {
    public static Person getPerson(String type){
        if("teacher".equals(type)){
            return new Teacher();
        }else if("student".equals(type)){
            return new Student();
        }else {
            return null;
        }
    }
}
