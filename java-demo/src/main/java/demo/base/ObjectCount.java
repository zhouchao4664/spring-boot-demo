package demo.base;

/**
 * @Author zhouchao
 * @Description 验证同一个String引用是否为同一个对象
 * @Date 2023/6/25 12:17
 */
public class ObjectCount {

    public static void main(String[] args) {
        String a = "xyz";
        String b = a;
        String c = a;

        Thread thread1 = new Thread(() -> {
            synchronized (b) {
                System.out.println("获取到了b的锁");
            }
        }, "线程1");

        Thread thread2 = new Thread(() -> {
            synchronized (c) {
                System.out.println("获取到了c的锁");
            }
        }, "线程2");

        thread1.start();
        thread2.start();
    }
}
