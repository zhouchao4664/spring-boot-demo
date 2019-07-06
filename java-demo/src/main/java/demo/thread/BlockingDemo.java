package demo.thread;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 2019/5/22
 * zhouchao
 */
public class BlockingDemo {

    ArrayBlockingQueue<String> ab = new ArrayBlockingQueue<>(10);

    public void init(){
        new Thread(()->{
            while (true){
                try {
                    String data = ab.take();
                    System.out.println(data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void add(String data){
        ab.add(data);
    }

    public static void main(String[] args) {
        BlockingDemo blockingDemo = new BlockingDemo();
        blockingDemo.init();
        for (int i = 0; i < 10; i++) {
            blockingDemo.add(i+"");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
