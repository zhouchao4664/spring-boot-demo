package com.zhouchao.controller;


import com.zhouchao.domain.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

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

    @PostMapping(value = "/person/json/to/properties",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = "application/properties+person"
    )
    public Person personPropertiesToJson(@RequestBody Person person){
        //@RequestBody 的内容是JSON
        //响应的内容是 Properties
        return person;
    }

    @PostMapping(value = "/person/properties/to/json",
            consumes = "application/properties+person",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public Person personJsonToProperties(@RequestBody Person person){
        //@RequestBody 的内容是 Properties
        //响应的内容是 JSON
        return person;
    }
}
