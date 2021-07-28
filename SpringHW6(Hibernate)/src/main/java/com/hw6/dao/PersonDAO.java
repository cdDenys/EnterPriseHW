package com.hw6.dao;

import com.hw6.entity.Person;
import java.util.List;

public interface PersonDAO {

    Person getById(Long id);

    void save(Person person);

    void edit(Person person);

    void delete(Person person);

    List<Person> findAll();
}
