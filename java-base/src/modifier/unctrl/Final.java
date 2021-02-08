package modifier.unctrl;

/**
 * final修饰符
 * 1)修饰属性：属性不可变
 * 2)修饰方法：该方法无法被子类修改
 * 3)修饰类：该类无法被继承
 */
public class Final {
    // 1.final修饰变量，i无法在代码中修改
    private final int i = 1;

    // 2.final修饰方法，该方法无法在Final的子类中修改
    public final void test(){
        System.out.println("hello");
    }
    // 3.final修饰类，无法继承A
    public final class A{

    }
    // public class B extends A{}
}
