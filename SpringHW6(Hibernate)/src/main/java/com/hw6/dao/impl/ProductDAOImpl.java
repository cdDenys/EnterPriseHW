package com.hw6.dao.impl;

import com.hw6.dao.ProductDAO;
import com.hw6.entity.Product;
import com.hw6.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {


    @Override
    public Product getById(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        return (Product) session.byId(Product.class).getReference(id);
    }

    @Override
    public void save(Product product) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
        session.close();
    }

    @Override
    public void edit(Product product) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(product);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Product product) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(product);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Product> findAll() {
        List<Product> users = (List<Product>)  HibernateUtil.getSessionFactory().openSession().createQuery("From Product").list();
        return users;
    }
}
