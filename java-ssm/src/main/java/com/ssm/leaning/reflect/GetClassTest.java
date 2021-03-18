package com.ssm.leaning.reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 获得Class对象
 */
public class GetClassTest {

    class User{
        private String name;
        private int age;
        public String nick;

        public User() {
        }

        public User(String name, int age, String nick) {
            this.name = name;
            this.age = age;
            this.nick = nick;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }
    }
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        GetClassTest getClassTest = new GetClassTest();

        // 1.通过Class.forName()获得。常用语配置文件
        Class<?> clazz1 = Class.forName("com.ssm.leaning.reflect.GetClassTest$User");

        // 2.通过User.class获得。常用于传参
        Class<?> clazz2 = User.class;

        // 3.通过user.getClass()获得。常用于获取字节码方式
        Class<?> clazz3 = getClassTest.new User().getClass();

        // 三个class都是同一个！！
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);


        System.out.println(clazz1);
        System.out.println(clazz1.getClass());
        System.out.println(clazz1.getClass().getClass());


        // 获得public的属性、方法、构造器
        System.out.println("---------------------1------------");
        Field[] fields = clazz1.getFields();
        Method[] method = clazz1.getMethods();
        Constructor<?>[] constructors = clazz1.getConstructors();
        for(Constructor constructor : constructors){
            System.out.println(constructor);
        }
        Field name = clazz1.getField("nick");
        System.out.println(name + " " +name.get(getClassTest.new User()));

        // 获得所有的属性、方法、构造器
        System.out.println("------------2-----------");
        Field[] fields2 = clazz1.getDeclaredFields();
        Method[] method2 = clazz1.getDeclaredMethods();
        Constructor<?>[] constructors2 = clazz1.getDeclaredConstructors();
        for(Field field : fields2){
            System.out.println(field);
        }
        // 设置name的值
        User user = getClassTest.new User();
        Field nameField = clazz1.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(user,"xiaoming");
        System.out.println(nameField.get(user));

        System.out.println("-----------3-构造器-创建对象----------");
        // 内部类，构造器必须有一个其所属的外部类
        Constructor<?> constructor = clazz1.getConstructor(GetClassTest.class);
        User user1 = (User) constructor.newInstance(new GetClassTest());
        System.out.println(user1);
        constructor = clazz1.getConstructor(GetClassTest.class,String.class,int.class,String.class);
        User user2 = (User) constructor.newInstance(new GetClassTest(),"小明", 1, "xm");
        System.out.println(user2);


        System.out.println("----------4-方法-执行方法----------");
        for (Method m : method2){
            System.out.println(m);
        }
        Method getName = clazz1.getDeclaredMethod("getName");
        System.out.println(getName.invoke(user2));

    }

}
