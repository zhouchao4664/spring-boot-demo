package demo.base;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @Author zhouchao
 * @Date 2021/3/25 13:55
 * @Description 布隆过滤器
 **/

public class BloomFilterDemo {
    private static final int total = 1000000;
    private static final BloomFilter<Integer> bf = BloomFilter.create(Funnels.integerFunnel(), total);

    public static void main(String[] args) {
        // 初始化数据
        for (int i = 0; i < total; i++) {
            bf.put(i);
        }

        // 匹配已在过滤器中的值，是否有匹配不上的
        for (int i = 0; i < total; i++) {
            if (!bf.mightContain(i)) {
                System.out.println("没有匹配上");
            }
        }

        // 匹配不在过滤器中的10000个值，有多少匹配出来
        int count = 0;
        for (int i = total; i < total + 10000; i++) {
            if (bf.mightContain(i)) {
                count++;
            }
        }
        System.out.println("误伤的数量：" + count);
    }

}
