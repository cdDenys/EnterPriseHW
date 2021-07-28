package com.hw6.service;

import com.hw6.entity.Person;

import java.util.List;

public interface PersonService {

    Person findById(Long id);

    void savePerson(Person person);

    void editPerson(Person person);

    void deletePerson(Person person);

    List<Person> getAllPeople();
}
