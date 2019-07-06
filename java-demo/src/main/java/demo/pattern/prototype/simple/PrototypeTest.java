package demo.pattern.prototype.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 2019/3/20
 * zhouchao
 *
 * 原型模式
 */
public class PrototypeTest {
    public static void main(String[] args) {
        ConcretePrototypeA concretePrototypeA = new ConcretePrototypeA();
        concretePrototypeA.setAge(18);
        concretePrototypeA.setName("zhouchao");
        List list = new ArrayList();
        concretePrototypeA.setHobbies(list);

        Client client = new Client();

        ConcretePrototypeA copy = (ConcretePrototypeA) client.startClone(concretePrototypeA);

        System.out.println(copy);
    }
}
