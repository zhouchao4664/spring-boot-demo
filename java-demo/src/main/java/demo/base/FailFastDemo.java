package demo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author zhouchao
 * @Date 2019/11/5 14:39
 * @Description
 *
 * 1、集合中只有'a','b'时，为什么循环3次并报错？
 * 2、集合中只有'a','b'时，为什么删除'a'不报错？
 * 3、集合中有五个元素时，为什么删除'd'不报错，删除'a'会报错
 *
 **/

public class FailFastDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
//        list.add("c");
//        list.add("d");
//        list.add("e");

        Iterator<String> it = list.iterator();

        int count = 1;
        while (it.hasNext()) {
            System.out.println("循环第" + count++ + "次");

            String item = it.next();
            if ("b".equals(item)) {
                list.remove(item);
            }
        }
    }
}
