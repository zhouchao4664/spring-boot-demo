package demo.pattern.prototype.deep;

import java.io.Serializable;

/**
 * 2019/3/20
 * zhouchao
 *
 * 原型模式
 */
public class JinGuBang implements Serializable {

    private float h = 100;
    private float d = 10;

    public void big() {
        this.d *= 2;
        this.h *= 2;
    }

    public void small() {
        this.d /= 2;
        this.h /= 2;
    }

}
