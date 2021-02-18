package demo.spring_boot.application.factory;

import demo.spring_boot.application.User;

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
