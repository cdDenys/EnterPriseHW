package com.example.demo.service;

import com.example.demo.model.Cart;
import com.example.demo.model.Person;

import java.util.List;

public interface PersonService {

    void createPerson(String name, Integer cartId, List<Person> personList, List<Cart> cartList);

    Person getPerson(String name, List<Person> personList);

    List<Person> getAllPeople(List<Person> personList);

    void editPerson(String findPerson, String newNameForPerson, Integer newCartId, List<Person> personList, List<Cart> cartList);

    void deletePerson(String findPerson, List<Person> personList);

}
