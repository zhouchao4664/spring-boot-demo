package com.zhouchao.mapper;

import com.zhouchao.pojo.User;

import java.util.List;

/**
 * @Author: zhouchao
 * @Date: 2021/05/04 20:18
 * @Description:
 */
public interface IUserMapper {
    //查询所有用户
    List<User> findAll();


    //根据条件进行用户查询
    User findByCondition(User user) ;
}
