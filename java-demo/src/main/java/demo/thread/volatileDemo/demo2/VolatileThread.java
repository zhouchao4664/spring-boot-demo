package demo.thread.volatileDemo.demo2;


/**
 * @Author zhouchao
 * @Date 2020/7/8 10:47
 * @Description
 **/
public class VolatileThread extends Thread {
    private Person person;
    private int i;

//    public VolitileThread(Person person) {
//        this.person = person;
//    }

    public VolatileThread(int i) {
        this.i = i;
    }

    @Override
    public void run(){
//        String name = RandomStringUtils.randomAlphabetic(4);
//        System.out.println(String.format("当前线程：%s，persen.name：%s",Thread.currentThread().getName(),name));
//        person.setName(name);
//
//        System.out.println(String.format("当前线程：%s，persen.name：%s",Thread.currentThread().getName(),person.getName()));
    }

}
