package demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hankeyao
 * @description: newSingleThreadExecutor创建“单线程化线程池”
 * 特点：
 * <p>
 * 单线程化的线程池中的任务是按照提交的次序顺序执行的
 * 只有一个线程的线程池
 * 池中的唯一线程的存活时间是无限的
 * 当池中的唯一线程正繁忙时，新提交的任务实例会进入内部的阻塞队列中，并且其阻塞队列是无界的
 * 适用场景：任务按照提交次序，一个任务一个任务地逐个执行的场景
 * @date 2023/2/21 10:48
 */
public class CreateSingleThreadPoolDemo {

    public static final int SLEEP_GAP = 1000;

    static class TargetTask implements Runnable {
        static AtomicInteger taskNo = new AtomicInteger(1);
        private String taskName;

        public TargetTask() {
            taskName = "task-" + taskNo;
            taskNo.incrementAndGet();
        }

        @Override
        public void run() {
            System.out.println("task:" + taskName + " 开始执行");
            try {
                Thread.sleep(SLEEP_GAP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task:" + taskName + " 结束执行");
        }
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 1; i++) {
            pool.execute(new TargetTask());
            pool.execute(new TargetTask());
        }
        pool.shutdownNow();
    }

}
