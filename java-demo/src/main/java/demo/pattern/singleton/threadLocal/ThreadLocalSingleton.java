package demo.pattern.singleton.threadLocal;

/**
 * 2019/3/14
 * zhouchao
 */
public class ThreadLocalSingleton {

    private ThreadLocalSingleton(){}

    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance =
            new ThreadLocal<ThreadLocalSingleton>(){
                @Override
                protected ThreadLocalSingleton initialValue(){
                    return new ThreadLocalSingleton();
                }
            };

    public  static ThreadLocalSingleton getInstance(){
        return threadLocalInstance.get();
    }

    public static void main(String[] args) {
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());

        Thread t1 = new Thread( new ExecutorThread());
        Thread t2 = new Thread( new ExecutorThread());

        t1.start();
        t2.start();
    }
}
