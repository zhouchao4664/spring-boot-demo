package demo.base;

/**
 * @Author zhouchao
 * @Date 2019/10/29 10:48
 * @Description
 **/

public class StringDemo {
    public static void main(String[] args) {
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
}
