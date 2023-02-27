package demo.question.q3;

import lombok.AllArgsConstructor;

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
    private Condition condition;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            lock.lock();
            try {
                condition.await();
                System.out.println("Z");
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
