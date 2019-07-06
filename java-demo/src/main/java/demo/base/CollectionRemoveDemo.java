package demo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 2019/3/6
 * zhouchao
 */
public class CollectionRemoveDemo {
    public static void main(String[] args) {

        List<Integer> list = CollectionRemoveDemo.getList();

        //常规做法
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }

        //正确做法
        list = CollectionRemoveDemo.getList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Integer num = list.get(0);
            list.remove(num);
        }

        //错误做法
        list = CollectionRemoveDemo.getList();
        for (Integer num : list) {
            list.remove(num);
        }

    }

    private static List<Integer> getList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        return list;
    }
}
