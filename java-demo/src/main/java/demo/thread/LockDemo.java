package demo.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 2019/5/11
 * zhouchao
 */
public class LockDemo {
    public static ReentrantLock lock = new ReentrantLock();

    public static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    static Map<String, Object> cacheMap = new HashMap<>();
    static Lock read = reentrantReadWriteLock.readLock();
    static Lock write = reentrantReadWriteLock.writeLock();


    public static int num = 0;

    public static void incr() {
        lock.tryLock();
        num++;
        lock.unlock();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(LockDemo::incr).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(num);
    }
}
