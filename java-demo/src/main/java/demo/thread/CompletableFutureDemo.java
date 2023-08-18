package demo.thread;

import java.util.concurrent.*;

/**
 * @Author zhouchao
 * @Description 测试CompletableFuture
 * @Date 2023/8/18 13:36
 */
public class CompletableFutureDemo {

    public static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0,
            10,
            30,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(10),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("处理任务");
            return "success";
        }, threadPoolExecutor);

        String s = completableFuture.get();
        System.out.println(s);
    }

}
