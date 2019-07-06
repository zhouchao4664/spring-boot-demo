package demo.sort;

import java.util.stream.Stream;

/**
 * 2019/3/12
 * zhouchao
 */
public class QuickSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] values) {
        int high = values.length - 1;
        int low = 0;
        quickSort(values, low, high);
    }

    private void quickSort(T[] values, int low, int high) {

        int start = low;
        int end = high;
        T key = values[low];

        while (end > start) {
            while (end > start && values[end].compareTo(key) >= 0) {
                end--;
            }
            if (values[end].compareTo(key) <= 0) {
                T temp = values[end];
                values[end] = values[start];
                values[start] = temp;
            }

            while (end > start && values[start].compareTo(key) <= 0) {
                start++;
            }
            if (values[start].compareTo(key) >= 0) {
                T temp = values[end];
                values[end] = values[start];
                values[start] = temp;
            }

        }

        if (start > low) {
            quickSort(values, low, start - 1);
        }
        if (end < high) {
            quickSort(values, end + 1, high);
        }
    }


    public static void main(String[] args) {
        Integer[] values = of(12, 20, 15, 16, 15, 1, 30, 45, 23, 9);
        //Integer[] values = of(3, 1, 2, 5, 4);
        Sort<Integer> sort = new QuickSort<>();
        sort.sort(values);
        Stream.of(values).forEach(System.out::println);
    }

    public static <T> T[] of(T... values) {
        return values;
    }
}
