package multhread.CAS;

import java.util.concurrent.atomic.AtomicInteger;

public class MyLock {

    private AtomicInteger state = new AtomicInteger(0);

    private Thread currentThread = null;

    public void lock(){
        if(state.get() > 0 && currentThread == Thread.currentThread()){
            state.incrementAndGet();
        }else {
            while(!state.compareAndSet(0,1));
            currentThread = Thread.currentThread();
        }
    }
    public void unLock(){
        state.decrementAndGet();
    }

    class TestThread extends Thread{

        @Override
        public void run() {
            super.run();
        }
    }


}
