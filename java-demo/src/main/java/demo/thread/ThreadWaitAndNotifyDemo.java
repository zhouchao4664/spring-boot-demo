package demo.thread;

/**
 * 2019/3/18
 * zhouchao
 */
public class ThreadWaitAndNotifyDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(ThreadWaitAndNotifyDemo::sayHelloWorld);
        t1.setName("T1");
        t1.start();

        Thread t2 = new Thread(ThreadWaitAndNotifyDemo::sayHelloWorld);
        t2.setName("T2");
        t2.start();

//        t1.notify();
//        t2.notify();

        Object monitor = ThreadWaitAndNotifyDemo.class;
        synchronized (monitor){
//            t1.notify();
//            t2.notify();
        }

        synchronized (monitor){
//            monitor.notify();
            monitor.notifyAll();
        }
    }

    public static void sayHelloWorld() {
        Thread currentThread = Thread.currentThread();
        Object monitor = ThreadWaitAndNotifyDemo.class;

        synchronized (monitor){
            System.out.printf("线程[%s] 进入等待状态...\n",currentThread.getName());
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("线程[%s] 恢复执行...\n",currentThread.getName());
        System.out.printf("线程[%s] Hello World!\n",currentThread.getName());
    }
}
