package demo.base;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.function.Supplier;

/**
 * 2019/1/27
 * zhouchao
 */
public class lambdaDemo {

    //SCFP -- Supplier、Comsumer、Function、Predicate
    //缺少 Action 模式

    //supplier模式
    String string1 = "Hello,World";

    Supplier<String> string2 = () -> "Hello,World";

    Supplier<String> string3 = () -> {return Integer.getInteger("2").toString();};

    //comsumer模式
//    String string1 = "Hello,World";
//
//    Supplier<String> string2 = () -> "Hello,World";
//
//    Supplier<String> string3 = () -> {Integer.getInteger("2").toString()};


    public static void main(String[] args) {

        //传统方法
        PropertyChangeListener listener1 = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                println(evt);
            }
        };

        //lambda方法
        PropertyChangeListener listener2 = evt -> {
            println(evt);
        };

        //lambda简略方法
        PropertyChangeListener listener3 = lambdaDemo::println;
    }

    public static void println(PropertyChangeEvent evt) {
        System.out.println(evt);
    }

}
