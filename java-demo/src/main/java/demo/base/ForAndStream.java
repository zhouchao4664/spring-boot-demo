package demo.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhouchao
 * @Date 2022/8/31 17:39
 * @Description: for循环和stream循环的性能对比
 */
public class ForAndStream {

    public static final List<Integer> nums = new ArrayList<>();

    public static final int INT = 10_000_000;

    public static void main(String[] args) {
        int i = 0;
        while (nums.size() <= INT) {
            nums.add(i++);
        }
        ForAndStream.print(nums.size());

        ForAndStream.foreachMethod();
        ForAndStream.foreachMethod();
        ForAndStream.streamMethod();
        ForAndStream.streamParallelMethod();
        ForAndStream.foriMethod();
    }


    public static void foriMethod() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < INT; i++) {
            ForAndStream.print(i);
        }
        long end = System.currentTimeMillis();

        System.out.println("for循环：" + (end - start));

    }

    public static void foreachMethod() {
        long start = System.currentTimeMillis();
        nums.forEach(ForAndStream::print);
        long end = System.currentTimeMillis();
        System.out.println("foreach循环：" + (end - start));
    }

    public static void streamMethod() {
        long start = System.currentTimeMillis();
        nums.stream().forEach(ForAndStream::print);
        long end = System.currentTimeMillis();
        System.out.println("stream循环：" + (end - start));
    }

    public static void streamParallelMethod() {
        long start = System.currentTimeMillis();
        nums.stream().parallel().forEach(ForAndStream::print);
        long end = System.currentTimeMillis();
        System.out.println("streamParallel循环：" + (end - start));
    }

    public static void print(Integer i){

    }

}
