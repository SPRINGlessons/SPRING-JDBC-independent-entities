package com.antonromanov.springhibernate.DAO;

import com.antonromanov.springhibernate.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession(){

        return sessionFactory.getCurrentSession();
    }

    public User getUserById (long id){
        return (User)currentSession().get(User.class, id);
    }

    public void save(User user) {

        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        //session.persist(user);
        //session.getTransaction().commit();
        tx.commit();
        session.close();


    }
/*
    public List<User> getPersonList() {

        Session session = this.sessionFactory.openSession();
        String hql = "from Test";
        List<User> personList = session.createQuery(hql).list();
        session.close();
        return personList;

    }

    */
}
