package com.zhouchao.controller;


import com.zhouchao.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link RestController}
 * 2019/5/22
 * zhouchao
 */
@RestController
public class PersonRestController {

    @GetMapping("/person/{id}")
    public Person person(@PathVariable Long id, @RequestParam(required = false) String name){
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        return person;
    }

}
