package com.hw6.service.impl;


import com.hw6.dao.impl.PersonDAOImpl;
import com.hw6.entity.Person;
import com.hw6.dao.PersonDAO;
import com.hw6.service.PersonService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {


    PersonDAO personDAO = new PersonDAOImpl();

    @Override
    public Person findById(Long id) {
        return personDAO.getById(id);
    }

    @Override
    public void savePerson(Person person) {
        personDAO.save(person);
    }

    @Override
    public void editPerson(Person person) {
        savePerson(person);
    }

    @Override
    public void deletePerson(Person person) {
        personDAO.delete(person);
    }

    @Override
    public List<Person> getAllPeople() {
        return personDAO.findAll();
    }
}
