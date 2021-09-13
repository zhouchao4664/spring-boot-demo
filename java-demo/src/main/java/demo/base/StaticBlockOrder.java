package demo.base;

/**
 * @Author: zhouchao
 * @Date: 2021/09/13 23:54
 * @Description: 此demo验证jvm执行顺序，如果静态代码块在静态变量之前，会先执行静态代码块的代码
 */
public class StaticBlockOrder {

    public static StaticBlockOrder s1 =  new StaticBlockOrder();
    public static StaticBlockOrder s2 =  new StaticBlockOrder();

    static{
        System.out.println("静态快");
    }

    {
        System.out.println("构造块");
    }

    public static void main(String[] args) {
        StaticBlockOrder s = new StaticBlockOrder();
    }
}
