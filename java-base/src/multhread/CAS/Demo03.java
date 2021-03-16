package multhread.CAS;

import java.util.concurrent.CountDownLatch;

public class Demo03 {
    public volatile static int count = 0;

    public static int threadSize = 100;

    public static CountDownLatch countDownLatch = new CountDownLatch(threadSize);

    public static void request() throws InterruptedException {

        Thread.sleep(5);

        while(!cas(count ,count + 1));

    }
    public static synchronized boolean cas(int expectCount , int newCount){
        if(expectCount == count){
            count = newCount;
            return true;
        }
        return false;
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
