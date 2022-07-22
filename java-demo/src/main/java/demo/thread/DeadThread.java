package demo.thread;

/**
 * @Author zhouchao
 * @Date 2022/6/28 16:04
 */
public class DeadThread {

    public final static Object LOCK_A = new Object();
    public final static Object LOCK_B = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread( ()-> {
            System.out.println("thread1-准备获取锁A。。。");
            synchronized (LOCK_A){
                System.out.println("thread1-获取到了锁A");
                System.out.println("thread1-准备获取锁B。。。");
                synchronized (LOCK_B){
                    System.out.println("thread1-获取到了锁B。。。");
                }
            }
        },"thread1");

        Thread thread2 = new Thread( ()-> {
            System.out.println("thread2-准备获取锁B。。。");
            synchronized (LOCK_B){
                System.out.println("thread2-获取到了锁B");
                System.out.println("thread2-准备获取锁A。。。");
                synchronized (LOCK_A){
                    System.out.println("thread2-获取到了锁A");
                }
            }
        },"thread2");

        thread1.start();
        thread2.start();
    }

}
