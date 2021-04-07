package classloader;

public class ClassLoaderPrint {
    static ClassLoaderPrint b = new ClassLoaderPrint();

    static int anInt = 100;

    public ClassLoaderPrint(){
        System.out.println("构造");
        System.out.println(anInt);
    }
    static {
        System.out.println("静态块");
    }
    {
        System.out.println("非静态块");
    }

    public static void main(String[] args) {
        ClassLoaderPrint c = new ClassLoaderPrint();
    }

}
/**
 *非静态块
 * 构造
 * 0
 * 静态块
 * 非静态块
 * 构造
 * 100
 * 【注】非静态块在构造函数之前执行
 */
