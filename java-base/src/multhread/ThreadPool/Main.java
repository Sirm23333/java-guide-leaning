package multhread.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {



    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10, // 核心线程数
                15, // 最大线程数，当等待队列满了的时候，会创建新的线程，直到达到最大线程数
                1,
                TimeUnit.SECONDS, // 存活时间，线程不执行任务超过多长时间，就消耗线程直到达到核心线程数
                new ArrayBlockingQueue<>(5), // 任务队列
                new ThreadPoolExecutor.AbortPolicy()); // 拒绝策略
    }

}
