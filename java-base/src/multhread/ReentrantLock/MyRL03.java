package multhread.ReentrantLock;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * 实现一把锁
 * 版本三：park+自旋
 * park可以阻塞当前线程，让出cpu，必须等待unpark唤醒
 *
 */
public class MyRL03 implements MyRL {

    private AtomicInteger state = new AtomicInteger(0);

    private Queue<Thread> parkQueue = new ArrayDeque<>();

    @Override
    public void lock(){

        while(!state.compareAndSet(0,1)){
            parkQueue.add(Thread.currentThread());
            LockSupport.park(); // 阻塞
        }

    }
    @Override
    public void unlock(){
        if(!parkQueue.isEmpty())
            LockSupport.unpark(parkQueue.poll());
        state.set(0);
    }


}
