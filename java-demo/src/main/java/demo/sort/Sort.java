package demo.sort;

/**
 * 2019/3/12
 * zhouchao
 * 排序接口
 * <p>
 * 原地（在地）排序 - In-Place
 * </p>
 */
public interface Sort<T extends Comparable<T>> {

    void sort(T[] values);

}
