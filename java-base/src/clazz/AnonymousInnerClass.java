package clazz;

import java.util.HashMap;
import java.util.Map;

public class AnonymousInnerClass {

    public static void main(String[] args) {
        // 实际为创建了一个AnonymousInnerClass的匿名内部类，该类继承了HashMap
        // 该匿名内部类中执行了一段非静态代码块
        // 非静态代码块，编译后会放到构造方法的"前部"，所以提前执行
        Map<String,Integer> map = new HashMap<String,Integer>(){
            int i = 2;
            {
                put("test",i);
            }
        };
        Map<String , Integer> map2 = new HashMap<>();
        System.out.println(map.getClass());
        System.out.println(map2.getClass());
        System.out.println(map instanceof HashMap);
    }
}
