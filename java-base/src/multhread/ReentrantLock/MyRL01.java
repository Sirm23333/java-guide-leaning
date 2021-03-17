package multhread.ReentrantLock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实现一把锁
 * 版本一：直接自旋
 * 通过CAS操作，设置一个state，简单
 *
 * 问题：浪费cpu资源啊！！！
 * 解决：拿不到资源就让出cpu
 *
 */
public class MyRL01 implements MyRL {

    private AtomicInteger state = new AtomicInteger(0);

    @Override
    public void lock(){

        while(!state.compareAndSet(0,1));

    }
    @Override
    public void unlock(){
        state.set(0);
    }


}
