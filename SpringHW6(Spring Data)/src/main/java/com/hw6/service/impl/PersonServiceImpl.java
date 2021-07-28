package com.hw6.service.impl;


import com.hw6.entity.Person;
import com.hw6.repository.PersonRepository;
import com.hw6.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person findById(Long id) {
        return personRepository.getById(id);
    }

    @Override
    public void savePerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void editPerson(Person person) {
        savePerson(person);
    }

    @Override
    public void deletePerson(Person person) {
        personRepository.delete(person);
    }

    @Override
    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }
}
