package demo.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 2019/3/31
 * zhouchao
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws Exception {

        CountDownLatch latch = new CountDownLatch(4);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //循环三次会阻塞
        for (int i = 0; i < 5; i++) {
            executorService.submit(()->{
                try {
                    echoThread();
                    latch.countDown(); //count -1
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        // count != 0 wait
        latch.await();

        executorService.shutdown();
    }

    private static void echoThread(){
        System.out.printf("当前线程[%s]正在执行...\n", Thread.currentThread().getName());
    }

}
