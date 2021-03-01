package demo.spring_boot.springbean;

import demo.spring_boot.application.spring.bean.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @Author zhouchao
 * @Date 2021/2/2 17:46
 * @Description
 **/

public class BeanDefinitionCreationDemo {
    public static void main(String[] args) {
        // 1.通过 BeanDefinitionBuilder 构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 通过属性设置
        beanDefinitionBuilder
                .addPropertyValue("id",1)
                .addPropertyValue("name","zhouchao");
        // 获取 BeanDefinition 实例
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();


        // 2.通过 AbstractBeanDefinition 以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        // 设置 Bean 类型
        genericBeanDefinition.setBeanClass(User.class);
        // 通过 MutablePropertyValues 批量操作属性
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues
                .add("id",1)
                .add("name","zhouchao");
        // 通过 set MutableProperValues 批量操作属性
        genericBeanDefinition.setPropertyValues(propertyValues);
    }

}
