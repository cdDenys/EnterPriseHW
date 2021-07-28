package com.hw6.controller;

import com.hw6.entity.Cart;
import com.hw6.entity.Person;
import com.hw6.service.CartService;
import com.hw6.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private CartService cartService;

    List<Cart> cartList = new ArrayList<>();

    @GetMapping("/findPersonById/{id}")
    public ResponseEntity<Person> findPersonById(@PathVariable("id") Long id){
        Person person = personService.findById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/create")
    public void createPerson(@RequestParam(name = "personName") String personName){
        Person person = new Person();
        person.setPersonName(personName);
        person.setCarts(cartService.showAllCarts());
        personService.savePerson(person);
    }

    @GetMapping("/findAllPeople")
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @PostMapping("/editPerson")
    public void editPerson(@RequestBody Person person){
        person.setCarts(cartService.showAllCarts());
        personService.editPerson(person);
    }

    @PostMapping("/deletePerson")
    public void deletePerson(@RequestBody Person person){
        personService.deletePerson(person);
    }


}
