package demo.base;

/**
 * 2019/3/9
 * zhouchao
 */
public class ThreadDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(ThreadDemo::sayHello);
        thread.run();
    }

    public static void sayHello(){
        System.out.printf("id: %s",Thread.currentThread().getId());
    }
}
