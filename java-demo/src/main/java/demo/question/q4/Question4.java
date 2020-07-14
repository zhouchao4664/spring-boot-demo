package demo.question.q4;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 通过阻塞队列实现写一个生产者-消费者队列
 * 2020/5/18
 * zhouchao
 */
public class Question4 {

    private static final LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(10);

    public static void main(String[] args) {
        Comsumer c = new Comsumer(linkedBlockingQueue);
        Producer p = new Producer(linkedBlockingQueue);

        Thread t1 = new Thread(() -> p.Producer());
        Thread t2 = new Thread(() -> c.Consumer());

        t1.start();
        t2.start();
    }

}
