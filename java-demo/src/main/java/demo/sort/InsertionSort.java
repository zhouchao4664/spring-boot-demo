package demo.sort;

import java.util.stream.Stream;

/**
 * 2019/3/12
 * zhouchao
 */
public class InsertionSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] values) {
        // Conparable.compareTo
        // <    return -1
        // =    return 0
        // >    return 1

        int size = values.length;
        for (int i = 1; i < size; i++) {
            //高位数 t
            // 不该在这里声明临时变量T t = values[i];
            for (int j = i - 1; j >= 0; j--) {
                if (values[j+1].compareTo(values[j]) < 1) {
                    T t = values[j+1];
                    values[j+1] = values[j]; //高位获取低位的值
                    values[j] = t; //低位获取高位的值
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] values = of(3, 2, 1, 5, 4);
        //Integer[] values = of(3, 1, 2, 5, 4);
        Sort<Integer> sort = new InsertionSort<>();
        sort.sort(values);
        Stream.of(values).forEach(System.out::println);
    }

    public static <T> T[] of(T... values) {
        return values;
    }
}
