package demo.base;

import java.lang.reflect.Field;

/**
 * @Author zhouchao
 * @Description 利用反射修改final变量的值，结果既没有报错，也没有修改成功
 * @Date 2023/12/28 15:44
 */
public class FinalReflectDemo {

    private final int a = 1;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        FinalReflectDemo finalReflectDemo = new FinalReflectDemo();
        System.out.println("修改之前的值：" + finalReflectDemo.a);

        Field a = FinalReflectDemo.class.getDeclaredField("a");

        a.setAccessible(true);
        a.setInt(finalReflectDemo, 2);
        System.out.println("修改之后的值：" + finalReflectDemo.a);
    }

}
