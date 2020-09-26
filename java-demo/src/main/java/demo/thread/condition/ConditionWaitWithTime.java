package demo.thread.condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author zhouchao
 * @Date 2020/8/12 16:59
 * @Description
 **/
public class ConditionWaitWithTime {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(new MyThread(lock,condition)).start();
    }

    static class MyThread implements Runnable {
        Lock LOCK;
        Condition CONDITION;

        public MyThread(Lock lock, Condition condition) {
            this.LOCK = lock;
            this.CONDITION = condition;
        }

        @Override
        public void run() {
            try {
                LOCK.lock();
                System.out.println("begin - conditionWait");
                CONDITION.await(2, TimeUnit.SECONDS);
                System.out.println("end - conditionWait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
            }
        }
    }
}
