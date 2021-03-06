package demo.springboot.application.spring.bean.factory;

import demo.springboot.application.spring.bean.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Author zhouchao
 * @Date 2021/2/18 17:29
 * @Description
 **/

public class UserFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
