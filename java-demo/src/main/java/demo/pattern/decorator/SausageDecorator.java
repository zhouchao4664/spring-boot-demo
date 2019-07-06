package demo.pattern.decorator;

/**
 * 2019/3/22
 * zhouchao
 *
 * 装饰器模式
 */
public class SausageDecorator extends BattercakeDecorator {

    public SausageDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    public String getMsg() {
        return super.getMsg() + "加1个香肠";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 2;
    }
}
