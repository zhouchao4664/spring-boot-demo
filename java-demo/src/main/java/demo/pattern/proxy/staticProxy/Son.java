package demo.pattern.proxy.staticProxy;

import demo.pattern.proxy.Person;

/**
 * 2019/3/21
 * zhouchao
 */
public class Son implements Person {

    @Override
    public void findLove() {
        System.out.println("肤白貌美大长腿");
    }
}
