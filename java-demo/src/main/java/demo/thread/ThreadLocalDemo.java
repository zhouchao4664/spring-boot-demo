package demo.thread;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: TODO
 * @Author : zhouchao
 * @Date : 2025-02-18 10:34
 */
@Slf4j
public class ThreadLocalDemo {

    public static final ThreadLocal<Person> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("tom");
        threadLocal.set(person);
        ThreadLocalDemo.handle(person);
        System.out.println("main person:" + threadLocal.get().getName());

    }

    public static void handle(Person person){
        List<String> componentList = new ArrayList<>();
        componentList.add("a");
        componentList.add("b");
        componentList.add("c");
        ExecutorService pdpExecutorService = Executors.newFixedThreadPool(componentList.size());

        for (String string : componentList) {
            pdpExecutorService.execute(() -> {
                threadLocal.set(person);
                Person p = threadLocal.get();
                System.out.println(String.format("thread：%s，value:%s，person：%s", Thread.currentThread().getName(), string, p));
                // p为null，因为每个线程都有自己的threadlocal，取值也是从这取值，
                p.setName("tom1");
                System.out.println(p == person);
            });
        }
        pdpExecutorService.shutdown();
    }

    @Data
    static class Person {
        String name;
    }

}
