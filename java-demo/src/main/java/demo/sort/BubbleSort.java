package demo.sort;

import java.util.stream.Stream;

/**
 * 2019/3/12
 * zhouchao
 */
public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] values) {

        // Conparable.compareTo
        // <    return -1
        // =    return 0
        // >    return 1

        int size = values.length - 1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size-i; j++) {
                // 第i号元素与i+1对比
                if (values[j+1].compareTo(values[j]) < 1) {
                    // 交换元素[i+1] = [i]
                    T t = values[j+1];
                    values[j+1] = values[j];
                    values[j] = t;
                    // 如果只是数字，不需要临时变量
                    // [0] = 3 , [1] = 2
                    // [1] = [1](2) + [0](3) = 5
                    // [0] = [1](5) - [0](3) = 2
                    // [1] = [1](5) - [0](2) = 3
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] values = of(3, 2, 1, 5, 4);
        Sort<Integer> sort = new BubbleSort<>();
        sort.sort(values);
        Stream.of(values).forEach(System.out::println);
    }

    public static <T> T[] of(T... values) {
        return values;
    }
}
