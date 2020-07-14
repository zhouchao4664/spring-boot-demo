package demo.question.q4;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 2020/5/18
 * zhouchao
 */
public class Comsumer {
    private LinkedBlockingQueue<String> linkedBlockingQueue;

    public Comsumer(LinkedBlockingQueue linkedBlockingQueue) {
        this.linkedBlockingQueue = linkedBlockingQueue;
    }

    public void Consumer(){
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String s = linkedBlockingQueue.poll();
            System.out.println("消费：" + s);
        }
    }

}
