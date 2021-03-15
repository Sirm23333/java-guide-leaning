package cas;

import java.util.concurrent.CountDownLatch;

/**
 * 存在并发问题
 * 在进行count++，经过三个过程
 *  1.A=count
 *  2.B=A+1
 *  3.count=B
 * 线程a和线程b并发进行时，如果顺序是以下形式
 *  (1)线程a执行完1， a.A=count
 *  (2)线程b执行完1， b.A=count
 *  (3)线程a执行完2， a.B=count+1
 *  (4)线程b执行完2， b.B=count+1
 *  (5)线程a执行完3， count=a.B
 *  (6)线程b执行完3， count=b.B
 *  此时count=count+1
 */
public class Demo01 {

    public static int count = 0;

    public static int threadSize = 100;

    public static CountDownLatch  countDownLatch = new CountDownLatch(threadSize);

    public static void request() throws InterruptedException {

        Thread.sleep(5);

        count++;

    }
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for(int i = 0; i < threadSize; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0; j < 10; j++){
                        try {
                            request();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println(count + " ----- use " + (end - start) + "ms");
    }



}
