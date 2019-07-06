package demo.pattern.proxy.dynamicProxy.cglibProxy;

/**
 * 2019/3/21
 * zhouchao
 *
 * 代理模式
 */
public class CglibTest {
    public static void main(String[] args) {
        try {
            Customer customer = (Customer) new CGlibMeipo().getInstance(Customer.class);
            customer.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
