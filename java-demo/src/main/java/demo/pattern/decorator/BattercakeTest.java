package demo.pattern.decorator;

/**
 * 2019/3/22
 * zhouchao
 *
 * 装饰器模式
 */
public class BattercakeTest {
    public static void main(String[] args) {
        Battercake battercake;
        battercake = new BaseBattercake();
        battercake = new EggDecorator(battercake);
        battercake = new SausageDecorator(battercake);
        System.out.println(battercake.getMsg());
    }
}
