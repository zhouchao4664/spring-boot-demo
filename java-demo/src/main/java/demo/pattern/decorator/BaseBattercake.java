package demo.pattern.decorator;

/**
 * 2019/3/22
 * zhouchao
 *
 * 装饰器模式
 */
public class BaseBattercake implements Battercake {

    public String getMsg() {
        return "煎饼";
    }

    public int getPrice() {
        return 5;
    }

}
