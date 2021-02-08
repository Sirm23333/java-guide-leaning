package modifier.unctrl;

/**
 *
 */
public class Abstract {

}

/**
 * A只能被继承，无法创建对象
 */
abstract class A{
    public void test1(){
        System.out.println();
    }
    // 必须由子类实现
    public abstract void test2();
}
