package com.arwka.springapp.dao;

import com.arwka.springapp.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //
    @Transactional
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }

    //
    public Person show(int id) {
        return null;
    }
    public Optional<Person> show(String email) {
        return null;
    }
    //
    public void save(Person person) {

    }

    //
    public void update(int id, Person updatedPerson) {

    }

    //
    public void delete(int id) {

    }
    /////////////////////////////////
    // testing multiple/batch update
    /////////////////////////////////
    public void testMultipleUpdate() {

    }

    public void testBatchUpdate() {

    }

    private List<Person> create1000People() {
        return null;
    }

}
