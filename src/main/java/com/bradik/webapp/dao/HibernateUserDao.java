package com.bradik.webapp.dao;

import com.bradik.webapp.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Brad on 30.06.2017.
 */

@Repository
public class HibernateUserDao implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        System.out.println("HibernateUserDao.findAll");
        return sessionFactory.getCurrentSession().createQuery("From User").getResultList();
    }

    public User findById(int id) {
        return sessionFactory.getCurrentSession().find(User.class, id);
    }

    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public void delete(int id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().getReference(User.class, id));
    }
}
