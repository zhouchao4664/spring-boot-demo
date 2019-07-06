package demo.pattern.singleton.threadLocal;

/**
 * 2019/3/14
 * zhouchao
 */
public class ExecutorThread implements Runnable {

    @Override
    public void run() {
        ThreadLocalSingleton singleton = ThreadLocalSingleton.getInstance();
        System.out.println(singleton);
    }
}
