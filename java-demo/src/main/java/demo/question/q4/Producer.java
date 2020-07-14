package demo.question.q4;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 2020/5/18
 * zhouchao
 */
public class Producer {
    private LinkedBlockingQueue<String> linkedBlockingQueue;

    public Producer(LinkedBlockingQueue linkedBlockingQueue) {
        this.linkedBlockingQueue = linkedBlockingQueue;
    }

    public void Producer() {
        int i = 0;
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
                i++;
                linkedBlockingQueue.put(i + "");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("生产：" + i);
        }
    }
}
