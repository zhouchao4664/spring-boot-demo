package demo.base;

import lombok.Data;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * @Author zhouchao
 * @Description bean的自省
 * @Date 2023/3/7 15:07
 */
@Data
public class BeanInfoDemo {
    private String code;
    private String value;
    private String des;

    public String getMsg() {
        return "msg";
    }

    public static void main(String[] args) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(BeanInfoDemo.class);
            System.out.println(beanInfo.getBeanDescriptor());
            System.out.println(Arrays.toString(beanInfo.getEventSetDescriptors()));
            System.out.println(Arrays.toString(beanInfo.getMethodDescriptors()));
            System.out.println(Arrays.toString(beanInfo.getPropertyDescriptors()));

            // 打印bean的所有属性值
            BeanInfoDemo beanInfoDemo = new BeanInfoDemo();
            for (PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors()) {
                Object obj = propertyDescriptor.getReadMethod().invoke(beanInfoDemo);
                System.out.println(String.format("%s : %s", propertyDescriptor.getName(), obj));
            }

        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
