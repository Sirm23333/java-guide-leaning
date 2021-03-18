package multhread.DCL;

import java.util.concurrent.locks.ReentrantLock;

public class DCLTest {

    // 对象需要加volatile
    // 因为JVM可能会发生指令重排序
    // 一个对象创建的过程  dclTest = new DCTTest()  简化为
    // 1.在栈中创建dclTest引用
    // 2.在堆中创建一个DCLTest对象
    // 3.初始化DCLTest对象
    // 4.dclTest执行该对象
    // 如果34发生了重排，则dclTest先不为null，再对实际对象做了初始化，如果在这两个操作中间，另一个线程拿到了dclTest，其中的值是一个默认状态的
    private static volatile DCLTest dclTest;

    private DCLTest(){

    }

    public static DCLTest getInstance(){
        if(dclTest == null){
            synchronized (DCLTest.class){
                // dcl
                if(dclTest == null){
                    dclTest = new DCLTest();
                }
            }
        }
        return dclTest;
    }


}
