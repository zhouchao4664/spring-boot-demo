package com.zhouchao.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhouchao.domain.Person;
import com.zhouchao.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


/**
 * @Author: zhouchao
 * @Date: 2021/05/28 18:53
 * @Description:
 */
@Service
public class PersonService extends ServiceImpl<PersonMapper, Person> {

    @Autowired
    private PersonMapper personMapper;

    public Person selectPerson(Integer id, String name) {
        LambdaQueryWrapper<Person> wrapper = new QueryWrapper<Person>().lambda();
        if (id != null) {
            wrapper.eq(Person::getId, id);
        }

        if (!StringUtils.isEmpty(name)) {
            wrapper.like(Person::getName, name);
        }

        Person person = personMapper.selectOne(wrapper);
        return person;
    }
}
