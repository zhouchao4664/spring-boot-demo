package demo.thread;

/**
 * 2019/5/11
 * zhouchao
 */
public class SynchronizedDemo {

    public static int num = 0;

    public synchronized static void incr() {
        num++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(SynchronizedDemo::incr).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(num);
    }
}
