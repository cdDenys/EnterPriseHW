package com.hw6.dao.impl;

import com.hw6.dao.PersonDAO;
import com.hw6.entity.Person;
import com.hw6.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {

    @Override
    public Person getById(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        return (Person) session.byId(Person.class).getReference(id);
    }

    @Override
    public void save(Person person) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();
    }

    @Override
    public void edit(Person person) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(person);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Person person) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(person);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Person> findAll() {
        List<Person> people = (List<Person>)  HibernateUtil.getSessionFactory().openSession().createQuery("From Person ").list();
        return people;
    }
}
