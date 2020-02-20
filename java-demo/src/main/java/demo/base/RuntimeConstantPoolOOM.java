package demo.base;

/**
 * @Author zhouchao
 * @Date 2020/2/20 11:06
 * @Description
 **/

public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        String s1 = new StringBuilder().append("计算机").append("软件").toString();
        String s2 = new StringBuilder().append("ja").append("va").toString();

        System.out.println(s1.intern() == s1);
        System.out.println(s2.intern() == s2);
    }
}
