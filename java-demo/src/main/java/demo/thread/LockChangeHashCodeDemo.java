package demo.thread;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author: zhouchao
 * @Date: 2021/07/13 15:18
 * @Description:
 */
public class LockChangeHashCodeDemo {
    private static final Object lock = new Object();

    public static void main(String[] args) throws Exception {
        Thread.sleep(5000);
        System.out.println("加锁前的hashCode是：" + System.identityHashCode(lock));
        System.out.println("对象头是：" + ClassLayout.parseInstance(lock).toPrintable());
        synchronized (lock){
            System.out.println("加锁前的hashCode是：" + System.identityHashCode(lock));
            System.out.println("对象头是：" + ClassLayout.parseInstance(lock).toPrintable());
        }
    }
}
