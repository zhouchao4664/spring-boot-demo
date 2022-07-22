package demo.base;

/**
 * @Date 2019/10/29 10:48
 * @Description
 **/

public class StringDemo {
    public static void main(String[] args) {
        StringDemo.test1();
        StringDemo.test2();
    }

    /**
     * 说明String的+操作，常量与变量的区别
     */
    private static void test1() {
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;

//        StringBuilder sb = new StringBuilder();
//        sb.append(d);
//        sb.append(2);
//        String e = sb.toString();

        //和上面的代码差不多一个意思
        String e = d + 2;
        System.out.println((a == c));
        System.out.println((a == e));
    }

    /**
     * 字符串的区别
     */
    private static void test2() {
        String s1 = "abcd";
        String s2 = "阿波次的";
        System.out.println("s1.length:" + s1.length() + "  s1.bytes.length:" + s1.getBytes().length);
        System.out.println("s2.length:" + s2.length() + "  s2.bytes.length:" + s2.getBytes().length);
    }
}
