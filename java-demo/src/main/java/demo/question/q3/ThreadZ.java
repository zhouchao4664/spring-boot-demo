package demo.question.q3;

import lombok.AllArgsConstructor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author zhouchao
 * @Description 打印Z的线程
 * @Date 2023/2/27 17:21
 */
@AllArgsConstructor
public class ThreadZ extends Thread {

    private Lock lock;
    private Condition condition3;
    private Condition condition1;
    private CountDownLatch COUNT_DOWN_LATCH;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            lock.lock();
            try {
                COUNT_DOWN_LATCH.countDown();
                condition3.await();
                System.out.println("Z");
                condition1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
