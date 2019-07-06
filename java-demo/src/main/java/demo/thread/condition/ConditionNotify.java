package demo.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 2019/5/19
 * zhouchao
 */
public class ConditionNotify implements Runnable {

    private Lock lock;
    private Condition condition;

    public ConditionNotify(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println("begin - conditionNotify");
            condition.signal();
            System.out.println("end - conditionNotify");
        } finally {
            lock.unlock();
        }
    }
}
