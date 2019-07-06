package demo.pattern.prototype.simple;

/**
 * 2019/3/20
 * zhouchao
 *
 * 原型模式
 */
public class Client {
//    private Prototype prototype;
//
//    public Client(Prototype prototype){
//        this.prototype = prototype;
//    }

    public Prototype startClone(Prototype prototype){
        return prototype.clone();
    }
}
