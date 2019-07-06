package demo.pattern.proxy.staticProxy;

/**
 * 2019/3/21
 * zhouchao
 */
public class FatherPrpxyTest {
    public static void main(String[] args) {
        Father father = new Father(new Son());

        father.findLove();

    }
}
