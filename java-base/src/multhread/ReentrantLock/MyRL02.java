package multhread.ReentrantLock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实现一把锁
 * 版本二：yield+自旋 或者 sleep+自旋
 * 当无法拿到state资源的时候，该线程直接yield让出cpu
 *
 * 问题：yield由操作系统调度，不可控，无法保证cpu下一次不会再执行这个线程，还是会造成cpu的浪费
 *      sleep睡眠+自旋，但睡眠时间不能确定
 * 解决：park+自旋
 */
public class MyRL02 implements MyRL {

    private AtomicInteger state = new AtomicInteger(0);
    @Override
    public void lock(){

        while(!state.compareAndSet(0,1)){
            Thread.yield();
        }

    }
    @Override
    public void unlock(){
        state.set(0);
    }


}
