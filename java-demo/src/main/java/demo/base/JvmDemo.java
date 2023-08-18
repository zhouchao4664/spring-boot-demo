package demo.base;

import lombok.Data;

/**
 * @Author zhouchao
 * @Date 2019/11/6 10:58
 * @Description jvm参数：-server -Xms10m -Xmx10m -XX:+PrintGC -XX:+DoEscapeAnalysis -XX:+UseTLAB -XX:+EliminateAllocations
 * 逃逸分析和标量替换决定是否栈上分配，不要用debug方式运行
 **/
public class JvmDemo {

    public static void main(String[] args) {
        JvmDemo d = new JvmDemo();
        for (int i = 0; i < 1000000; i++) {
            d.memoryTest();
        }
    }

    private void memoryTest() {
        Person p = new Person();
        p.setI(1);
    }

    @Data
    class Person {
        Integer i;
    }

}
