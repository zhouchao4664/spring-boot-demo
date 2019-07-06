package demo.pattern.prototype.deep;

import java.io.*;
import java.util.Date;

/**
 * 2019/3/20
 * zhouchao
 *
 * 原型模式
 *
 * 原型模式
 */
public class QiTianDaShen extends Monkey implements Cloneable , Serializable {

    public JinGuBang jinGuBang;

    public QiTianDaShen(){
        this.setBirthday(new Date());
        this.setJinGuBang(new JinGuBang());
    }

    public JinGuBang getJinGuBang() {
        return jinGuBang;
    }

    public void setJinGuBang(JinGuBang jinGuBang) {
        this.jinGuBang = jinGuBang;
    }

    public Object deepClone(){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            QiTianDaShen copy = (QiTianDaShen) ois.readObject();

            copy.setBirthday(new Date());

            return copy;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public QiTianDaShen shallowClone(QiTianDaShen target){

        QiTianDaShen qiTianDaShen=new QiTianDaShen();
        qiTianDaShen.setHeight(target.getHeight());
        qiTianDaShen.setWeight(target.getWeight());
        qiTianDaShen.setJinGuBang(target.getJinGuBang());
        qiTianDaShen.setBirthday(new Date());

        return qiTianDaShen;

    }
}
