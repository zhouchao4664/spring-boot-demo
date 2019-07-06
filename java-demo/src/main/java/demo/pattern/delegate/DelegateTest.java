package demo.pattern.delegate;

/**
 * 2019/3/13
 * zhouchao
 *
 * 委派模式
 */
public class DelegateTest {
    public static void main(String[] args) {
        new Boss().commend("架构",new Leader());
    }
}
