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
            notify();
        }
    }

    public synchronized Object pop() throws Exception {
        synchronized (list) {
            if (list.size() <= 0) {
                wait();
            }
            return list.removeLast();
        }
    }
}
