package demo.pattern.decorator;

/**
 * 2019/3/22
 * zhouchao
 *
 * 装饰器模式
 */
public abstract class BattercakeDecorator implements Battercake {
    private Battercake battercake;

    public BattercakeDecorator(Battercake battercake) {
        this.battercake = battercake;
    }

    @Override
    public String getMsg() {
        return this.battercake.getMsg();
    }

    @Override
    public int getPrice() {
        return this.battercake.getPrice();
    }
}
