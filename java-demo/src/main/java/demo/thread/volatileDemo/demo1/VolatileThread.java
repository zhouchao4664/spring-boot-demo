package demo.thread.volatileDemo.demo1;

/**
 * 2019/5/19
 * zhouchao
 */
public class VolatileThread {

    public static volatile int i = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                i++;
            }
        });
        t1.start();

        new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);

            t1.interrupt();
        }).start();
    }

}
