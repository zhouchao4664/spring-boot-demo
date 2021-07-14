package demo.thread;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author: zhouchao
 * @Date: 2021/07/13 15:18
 * @Description:
 * 对于偏向锁，在线程获取偏向锁时，会用Thread ID和epoch值覆盖identity hash code所在的位置。
 * 如果一个对象的hashCode()方法已经被调用过一次之后，这个对象还能被设置偏向锁么？
 * 答案是不能。因为如果可以的化，那Mark Word中的identity hash code必然会被偏向线程Id给覆盖，
 * 这就会造成同一个对象前后两次调用hashCode()方法得到的结果不一致。
 */
public class LockChangeHashCodeDemo {
    private static final Object lock = new Object();

    public static void main(String[] args) throws Exception {
        System.out.println("对象头是：" + ClassLayout.parseInstance(lock).toPrintable());
        System.out.println("加锁前的hashCode是：" + System.identityHashCode(lock));
        System.out.println("对象头是：" + ClassLayout.parseInstance(lock).toPrintable());
        synchronized (lock){
            System.out.println("对象头是：" + ClassLayout.parseInstance(lock).toPrintable());
            System.out.println("加锁前的hashCode是：" + System.identityHashCode(lock));
            System.out.println("对象头是：" + ClassLayout.parseInstance(lock).toPrintable());
        }
    }
}
