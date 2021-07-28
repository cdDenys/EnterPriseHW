package com.hw6.dao.impl;

import com.hw6.dao.CartDAO;
import com.hw6.entity.Cart;
import com.hw6.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;


public class CartDAOImpl implements CartDAO {


    @Override
    public Cart getById(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        return (Cart) session.byId(Cart.class).getReference(id);
    }

    @Override
    public void save(Cart cart) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(cart);
        transaction.commit();
        session.close();
    }

    @Override
    public void edit(Cart cart) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(cart);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Cart cart) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(cart);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Cart> findAll() {
        List<Cart> carts = (List<Cart>)  HibernateUtil.getSessionFactory().openSession().createQuery("From Cart").list();
        return carts;
    }
}
