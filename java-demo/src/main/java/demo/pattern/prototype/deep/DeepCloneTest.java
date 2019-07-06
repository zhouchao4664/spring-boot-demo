package demo.pattern.prototype.deep;

/**
 * 2019/3/20
 * zhouchao
 *
 * 原型模式
 */
public class DeepCloneTest {
    public static void main(String[] args) {
        QiTianDaShen qiTianDaShen = new QiTianDaShen();
        QiTianDaShen clone = (QiTianDaShen) qiTianDaShen.deepClone();

        System.out.println("深克隆："+(qiTianDaShen.getJinGuBang() == clone.getJinGuBang()));

        QiTianDaShen q = new QiTianDaShen();
        QiTianDaShen n = q.shallowClone(q);
        System.out.println("浅克隆："+(q.getJinGuBang() == n.getJinGuBang()));
    }
}
