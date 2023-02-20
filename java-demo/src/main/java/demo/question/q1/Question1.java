package demo.question.q1;

import java.util.LinkedList;

/**
 * 问答1、 下面的代码在绝大部分时间内都运行得很正常，请问在什么情况下会出现问题？问题的根源在哪里？
 * 2020/5/18
 * zhouchao
 */
public class Question1 {
    LinkedList list = new LinkedList();

    public synchronized void push(Object x) {
        synchronized (list) {
            list.addLast(x);
            System.out.println("执行唤醒");
            notify();
        }
    }

    public synchronized Object pop() throws Exception {
        synchronized (list) {
            if (list.size() <= 0) {
                System.out.println("等待");
                wait();
            }
            return list.removeLast();
        }
    }

    public static void main(String[] args) {
        Question1 q = new Question1();
        Thread t1 = new Thread(() -> {
            try {
                q.pop();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }, "线程1");

        Thread t2 = new Thread(() -> {
            Object x = new Object();
            q.push(x);
        }, "线程2");

        t1.start();
        t2.start();
    }
}
