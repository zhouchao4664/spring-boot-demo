package demo.pattern.proxy.staticProxy;

import demo.pattern.proxy.Person;

/**
 * 2019/3/21
 * zhouchao
 */
public class Father implements Person {

    private Person person;

    public Father(Person person){
        this.person = person;
    }

    @Override
    public void findLove() {
        System.out.println("父亲物色对象");
        person.findLove();
        System.out.println("双方父母同意，确立关系");
    }
}
