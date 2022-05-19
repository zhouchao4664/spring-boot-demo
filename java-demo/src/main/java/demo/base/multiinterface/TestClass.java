package demo.base.multiinterface;

/**
 * @Author zhouchao
 * @Date 2022/5/19 18:29
 * @Description: 如果两个接口的default方法签名一样，那么类在继承的时候必须要实现这个相同的方法
 */
public class TestClass implements InterfaceA,InterfaceB {

    @Override
    public void print() {

    }
}
