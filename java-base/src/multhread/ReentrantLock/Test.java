package multhread.ReentrantLock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    static ReentrantLock reentrantLock = new ReentrantLock(true);
    static MyRL myRL = new MyRL03();
    static int count = 0;

    static CountDownLatch countDownLatch = new CountDownLatch(10);
    public static void add(){
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }


    public static void main(String[] args) throws InterruptedException {
        int a = 1, b = 2, c = 3;
        a = b = c;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
//
        reentrantLock.lock();
////                    myRL.lock();
//        add();
        reentrantLock.unlock();

//        for(int i = 0; i < 10; i++){
//            new Thread(() -> {
//                for(int j = 0; j < 100; j++){
//                    reentrantLock.lock();
////                    myRL.lock();
//                    add();
//                    reentrantLock.unlock();
////                    myRL.unlock();
//                }
//                countDownLatch.countDown();
//            }).start();
//        }
//        countDownLatch.await();
//        System.out.println(count);



    }

}
