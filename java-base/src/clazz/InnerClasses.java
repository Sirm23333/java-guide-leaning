package clazz;

/**
 * 内部类测试
 * 定义在类里面
 * 1.成员内部类
 * 2.局部内部类
 * 3.匿名类
 */
public class InnerClasses {
    private int a;

    /**
     * 1.成员内部类(相当于类的属性)
     *      1)可以使用和属性相同的访问控制符来修饰，相当与类的属性
     *      2)可以使用static/final修饰
     */
    public class A{}
    protected class B{}
    private class C{}
    class D{}
    static class G{}
    final class E{}

    /**
     * 2.局部内部类
     *   1)不加控制修饰符，只有该方法可以访问
     *   2)可以用final修饰
     *   3)局部内部类如果要访问所在方法的局部变量，那么这个局部变量必须是有效final的（java8开始final可以省略不写），
     *      因为局部变量在栈内存中，方法结束后就消失了，局部内部类的对象在堆内存中持续存在直到垃圾回收消失，为了避免冲突，
     *      局部内部类copy了一份局部变量，必须保证局部变量不会变。
     */
    public void test(){
        int i = 1;
        final int j = 2;
        class E{
            public void print(){
                // 使用i 默认i为final，但是如果有对i的操作，就会通不过编译
                System.out.println(i);
                System.out.println(j);
            }
        }
        final class F{}
        // 如果加了i=2，上面会报错
        // i = 2;
    }
    /**
     * 3.匿名类
     *      1)实现一个接口
     *      2)对象只能在实现这个接口的域中（方法内或者类内）创建使用
     */
    public interface AnonInterface {
        void fun();
    }
    AnonInterface anon1 = new AnonInterface(){
        @Override
        public void fun() {
            System.out.println("anon1");
        }
    };
    public void test2(){
        AnonInterface anon2 = new AnonInterface() {
            @Override
            public void fun() {
                System.out.println("fun2");
            }
        };
        anon1.fun();
        anon2.fun();
    }
}
