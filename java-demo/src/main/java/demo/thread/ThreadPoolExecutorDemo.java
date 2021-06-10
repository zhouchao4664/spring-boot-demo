package demo.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 2019/5/8
 * zhouchao
 */
public class ThreadPoolExecutorDemo {

    public static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0,
            10,
            30,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(10),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        threadPoolExecutor.submit(()->{
            System.out.println("线程执行");
        });
    }
}
