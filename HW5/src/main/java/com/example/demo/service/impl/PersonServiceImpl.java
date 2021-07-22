package com.example.demo.service.impl;

import com.example.demo.model.Cart;
import com.example.demo.model.Person;
import com.example.demo.service.CartService;
import com.example.demo.service.PersonService;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    CartService cartService = new CartServiceImpl();
    @Override
    public void createPerson(String name, Integer cartId, List<Person> personList, List<Cart> cartList) {
        Person person = new Person();
        person.setName(name);
        person.setCart(cartService.getCart(cartId, cartList));
        personList.add(person);
    }

    @Override
    public Person getPerson(String name, List<Person> personList) {
        Person person = new Person();
        for (Person value : personList) {
            if (value.getName().equals(name)) {
                person = value;
            }
        }
        return person;
    }

    @Override
    public List<Person> getAllPeople(List<Person> personList) {
        return personList;
    }

    @Override
    public void editPerson(String findPerson, String newNameForPerson,
                           Integer newCartId, List<Person> personList, List<Cart> cartList) {
        if (personList.toString().contains(findPerson)){
            personList.removeIf(item -> item.getName().equals(findPerson));
            createPerson(newNameForPerson, newCartId, personList, cartList);
        }else {
            System.out.println("Person not found");
        }
    }

    @Override
    public void deletePerson(String findPerson, List<Person> personList) {
        personList.removeIf(item -> item.getName().equals(findPerson));
    }
}
