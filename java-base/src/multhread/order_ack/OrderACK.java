package multhread.order_ack;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 利用AQS线程队列思想解决消息多线程消费的ACK问题
 */
public class OrderACK {

    public static BlockingQueue<Task> taskQueue = new LinkedBlockingQueue();
    public static Queue<Task> handlingTask = new ArrayDeque();
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        Producer producer = new Producer();
        ConsumerMaster consumer = new ConsumerMaster();
        producer.start();
        consumer.start();
        while(true){
            lock.lock();
            while(!handlingTask.isEmpty() && handlingTask.peek().state == 1){
                Task poll = handlingTask.poll();
                System.out.println(poll.id + "执行结束");
            }
            condition.await();
            lock.unlock();
        }
    }

    static class  Producer extends Thread{
        private Random random = new Random();
        @Override
        public void run() {
            int i = 0;
            while(true){
                Task task = new Task(i++ , random.nextInt(1000) , 0);
                try {
                    taskQueue.put(task);
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ConsumerMaster extends Thread{
        private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1024,1024,10,
                TimeUnit.SECONDS,new LinkedBlockingQueue<>());
        @Override
        public void run() {
            while(true){
                try {
                    Task task = taskQueue.take();
                    handlingTask.add(task);
                    threadPoolExecutor.submit(new ConsumerWorker(task));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    static class ConsumerWorker extends Thread{
        private Task task;
        public ConsumerWorker(Task task){
            this.task = task;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(task.during);
                OrderACK.lock.lock();
                task.state = 1;
                OrderACK.condition.signalAll();
                OrderACK.lock.unlock();;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class Task{
        private int id;
        private int during;
        private int state;

        public Task(int id, int during,int state) {
            this.id = id;
            this.during = during;
            this.state = state;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getDuring() {
            return during;
        }

        public void setDuring(int during) {
            this.during = during;
        }
    }


}
