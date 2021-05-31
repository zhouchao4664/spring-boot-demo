package com.zhouchao.controller;


import com.zhouchao.domain.Person;
import com.zhouchao.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * {@link RestController}
 * 2019/5/22
 * zhouchao
 */
@RestController
public class PersonRestController {

    @Autowired
    private PersonService personService;

    @GetMapping("/person/{id}")
    public Person person(@PathVariable Integer id, @RequestParam(required = false) String name){
        Person person = personService.selectPerson(id,name);
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
