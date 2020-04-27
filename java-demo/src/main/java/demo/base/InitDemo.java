package demo.base;

/**
 * @Author zhouchao
 * @Date 2020/4/26 21:44
 * @Description
 **/

public class InitDemo {

    static class DeadLoopClass{
        static {
            System.out.println(Thread.currentThread() + "init InitDemo");
            if (true){
                while (true){
                }
            }
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+"start");
                DeadLoopClass deadLoopClass = new DeadLoopClass();
                System.out.println(Thread.currentThread()+"start");
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }
}
