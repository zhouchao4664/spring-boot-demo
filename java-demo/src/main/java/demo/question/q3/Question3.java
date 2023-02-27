package demo.question.q3;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1、编写代码，使用3个线程，1个线程打印X，一个线程打印Y，一个线程打印Z，同时执行连续打印10次"XYZ"
 * 2020/5/18
 * zhouchao
 */
public class Question3 {
    public static final ReentrantLock LOCK = new ReentrantLock(true);
    public static final Condition CONDITION = LOCK.newCondition();

    public static void main(String[] args) {
        ThreadX threadX = new ThreadX(LOCK, CONDITION);
        ThreadY threadY = new ThreadY(LOCK, CONDITION);
        ThreadZ threadZ = new ThreadZ(LOCK, CONDITION);

        CompletableFuture.runAsync(() -> threadX.start())
                .thenRun(() -> threadY.start())
                .thenRun(() -> threadZ.start());

        System.out.println("线程开始运行");
        LOCK.lock();
        try {
            CONDITION.signal();
        } finally {
            LOCK.unlock();
        }
    }


}
