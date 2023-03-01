package demo.question.q3;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1、编写代码，使用3个线程，1个线程打印X，一个线程打印Y，一个线程打印Z，同时执行连续打印10次"XYZ"
 * 2020/5/18
 * zhouchao
 */
public class Question3 {
    public static final ReentrantLock LOCK = new ReentrantLock(true);
    public static final Condition CONDITION1 = LOCK.newCondition();
    public static final Condition CONDITION2 = LOCK.newCondition();
    public static final Condition CONDITION3 = LOCK.newCondition();

    public static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {
        ThreadX threadX = new ThreadX(LOCK, CONDITION1,CONDITION2,COUNT_DOWN_LATCH);
        ThreadY threadY = new ThreadY(LOCK, CONDITION2,CONDITION3,COUNT_DOWN_LATCH);
        ThreadZ threadZ = new ThreadZ(LOCK, CONDITION3,CONDITION1,COUNT_DOWN_LATCH);

        threadY.start();
        threadX.start();
        threadZ.start();

        COUNT_DOWN_LATCH.await();

        LOCK.lock();
        try {
            CONDITION1.signal();
        } finally {
            LOCK.unlock();
        }
    }


}
