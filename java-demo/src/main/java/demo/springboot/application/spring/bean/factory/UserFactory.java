package demo.springboot.application.spring.bean.factory;

import demo.springboot.application.spring.bean.User;

/**
 * @Author zhouchao
 * @Date 2021/2/18 16:53
 * @Description
 **/

public interface UserFactory {

    default User createUser(){
        return User.createUser();
    }
}
