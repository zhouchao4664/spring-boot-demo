package demo.base;

/**
 * @Author zhouchao
 * @Date 2020/9/27 11:24
 * @Description int常量池中初始化-128~127的范围
 **/

public class IntegerDemo {

    public static void main(String[] args) {
        Integer i1 = 1;
        Integer i2 = 1;
        System.out.println(i1 == i2);
        Integer j1 = 1000;
        Integer j2 = 1000;
        System.out.println(j1 == j2);
    }

}
