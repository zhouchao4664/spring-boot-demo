package demo.pattern.proxy.dynamicProxy.JDKProxy;

import demo.pattern.proxy.Person;

/**
 * 2019/3/21
 * zhouchao
 *
 * 代理模式
 */
public class Girl implements Person {
    @Override
    public void findLove() {
        System.out.println("高富帅");
        System.out.println("身高180cm");
        System.out.println("有6块腹肌");
    }
}
