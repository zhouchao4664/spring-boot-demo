package demo.base;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * 2019/2/11
 * zhouchao
 */
public class GenericWildcardsTypeDemo {

    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();
        upperBoundsWildcards(numbers);

        println(numbers);
    }

    private static void upperBoundsWildcards(List<Number> numbers) {
        numbers.add(Byte.valueOf((byte) 1));
        numbers.add(Short.valueOf((short) 2));
        numbers.add(Integer.valueOf(3));
        numbers.add(Long.valueOf(4l));

        List<Byte> bytes = Arrays.asList((byte) 5);
        List<Short> shorts = Arrays.asList((short) 6);
        List<Integer> integers = Arrays.asList(7);
        List<Long> longs = Arrays.asList(8l);

        numbers.addAll(bytes);
        numbers.addAll(shorts);
        numbers.addAll(integers);
        numbers.addAll(longs);

        println(numbers);

        System.out.println("===============================");

        forEach(numbers, System.out::println);
    }

    private static void println(Iterable<?> iterable) {
        for (Object obj : iterable) {
            System.out.println(obj);
        }
    }

//    private static void println(Iterable<Object> iterable) {
//        for (Object obj : iterable) {
//            System.out.println(obj);
//        }
//    }

    private static void forEach(Iterable<? extends Number> iterable, Consumer<Number> consumer) {
        for (Number number : iterable) {
            consumer.accept(number);
        }
    }


}


