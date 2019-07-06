package demo.thread;

/**
 * 2019/3/16
 * zhouchao
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.printf("县城[Id : %s] : Hello World!\n",Thread.currentThread().getId());
        });

        thread.start();
    }

}
