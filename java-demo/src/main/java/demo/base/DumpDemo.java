package demo.base;

import lombok.Data;

import java.util.LinkedList;

/**
 * @Author zhouchao
 * @Description -Xms1m -Xmx1m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:/dump/heap.hprof
 * @Date 2023/8/11 15:07
 */
public class DumpDemo {

    public static void main(String[] args) {
        LinkedList<LocalObject> list = new LinkedList();

        while (true) {
            LocalObject localObject = new LocalObject();
            list.add(localObject);
        }
    }

    @Data
    static class LocalObject {
        private String a;
        private Integer b;
    }

}
