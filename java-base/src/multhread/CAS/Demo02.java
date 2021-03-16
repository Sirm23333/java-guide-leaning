package multhread.CAS;

import java.util.concurrent.CountDownLatch;

/**
 *   1.A=count
 *   2.B=A+1
 *   3.count=B
 * 为了解决Demo01中的问题，可以将request()加锁处理
 * 这样将123步串行处理
 * 效率太低，并行没有意义
 */
public class Demo02 {

    public static int count = 0;

    public static int threadSize = 100;

    public static CountDownLatch countDownLatch = new CountDownLatch(threadSize);

    public static synchronized void request() throws InterruptedException {

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
