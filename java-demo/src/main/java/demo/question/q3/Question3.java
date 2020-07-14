package demo.question.q3;

/**
 * 1、编写代码，使用3个线程，1个线程打印X，一个线程打印Y，一个线程打印Z，同时执行连续打印10次"XYZ"
 * 2020/5/18
 * zhouchao
 */
public class Question3 {
    volatile Boolean lock1 = Boolean.TRUE;
    volatile Boolean lock2 = Boolean.FALSE;
    volatile Boolean lock3 = Boolean.FALSE;

    class Thread1 implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i<10;i++){
                if(lock1){
                    try {
                        Thread.currentThread().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("x");
                lock1 = Boolean.FALSE;
                lock2 = Boolean.TRUE;
                notify();
            }
        }
    }

    class Thread2 implements Runnable{
        @Override
        public void run() {
            for(int i = 0; i<10;i++){
                if(lock2){
                    try {
                        Thread.currentThread().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("y");
                lock2 = Boolean.FALSE;
                lock3 = Boolean.TRUE;
                notify();
            }
        }
    }

    class Thread3 implements Runnable{
        public void run(){
            for(int i = 0; i<10;i++){
                if(lock3){
                    try {
                        Thread.currentThread().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("z");
                lock3 = Boolean.FALSE;
                lock1 = Boolean.TRUE;
                notify();
            }
        }
    }

    public static void main(String[] args) {
//        Thread1 thread1 = new Thread1();
//        Thread2 thread2 = new Thread2();
//        Thread3 thread3 = new Thread3();
//        thread1.start();
//        thread2.start();
//        thread3.start();
    }


}
