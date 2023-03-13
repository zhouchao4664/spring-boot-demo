package demo.base;

/**
 * @Author zhouchao
 * @Description 位运算符计算
 * @Date 2023/3/13 11:31
 */
public class BitCalculate {

    public static void main(String[] args) {
        /**
         * & 按位与,只有对应的两个二进位均为1时，结果位才为1 ，否则为0
         *
         * 0000 1001
         * 0000 0101
         * 0000 0001
         */
        System.out.println(9 & 5);

        /**
         * | 按位或,只要对应的二个二进位有一个为1时，结果位就为1
         *
         * 0000 1001
         * 0000 0101
         * 0000 1101
         */
        System.out.println(9 | 5);

        /**
         * ^ 按位异或,当两对应的二进位相异时，结果为1。
         *
         * 0000 1001
         * 0000 0101
         * 0000 1100
         */
        System.out.println(9 ^ 5);
    }

}
