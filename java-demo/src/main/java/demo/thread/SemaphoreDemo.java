package demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 2019/3/31
 * zhouchao
 */
public class SemaphoreDemo {

    public static void main(String[] args) throws Exception {

        Semaphore semaphore = new Semaphore(4);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //循环三次会阻塞
        for (int i = 0; i < 5; i++) {
            executorService.submit(()->{
                try {
                    semaphore.acquire(); //count -1
                    echoThread();
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        // count != 0 wait
        Thread.sleep(500);

        executorService.shutdown();
    }

    private static void echoThread(){
        System.out.printf("当前线程[%s]正在执行...\n", Thread.currentThread().getName());
    }

}
