package demo.pattern.proxy.dynamicProxy.JDKProxy;

import demo.pattern.proxy.Person;

/**
 * 2019/3/21
 * zhouchao
 *
 * 代理模式
 */
public class JDKProxyTest {
    public static void main(String[] args) {
        Person obj = (Person) new JDKMeipo().getInstance(new Girl());

        obj.findLove();
    }
}
