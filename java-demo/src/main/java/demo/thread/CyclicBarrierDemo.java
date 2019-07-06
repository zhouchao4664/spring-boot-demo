package demo.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 2019/3/31
 * zhouchao
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) throws Exception {

        CyclicBarrier barrier = new CyclicBarrier(4);

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        //循环三次会阻塞
        for (int i = 0; i < 3; i++) {
            executorService.submit(()->{
                try {
                    echoThread();
                    barrier.await(); //count -1
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        // count != 0 wait
        Thread.sleep(500);
        System.out.println(barrier.getNumberWaiting());
        barrier.await();
        System.out.println(barrier.getNumberWaiting());

        barrier.reset();

        executorService.shutdown();
    }

    private static void echoThread(){
        System.out.printf("当前线程[%s]正在执行...\n", Thread.currentThread().getName());
    }

}
