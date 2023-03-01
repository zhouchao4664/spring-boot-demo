package demo.thread.volatileDemo.demo2;


/**
 * @Author zhouchao
 * @Date 2020/7/8 10:42
 * @Description
 **/

public class VolatileDemo2 {

    static int a;
    Person gg;

    public static void main(String[] args) {
        Person person = new Person(1, "张三");

        int x = 1;

//        VolitileThread t1 = new VolitileThread(person);
//        VolitileThread t2 = new VolitileThread(person);

        VolatileThread t1 = new VolatileThread(x);
        VolatileThread t2 = new VolatileThread(x);
        t1.start();
        t2.start();
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println(String.format("当前线程：%s，persen.name：%s", Thread.currentThread().getName(), person.getName()));
        System.out.println(String.format("当前线程：%s，x：%s", Thread.currentThread().getName(), x));

    }


}
