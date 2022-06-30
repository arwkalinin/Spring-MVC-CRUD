package com.arwka.springapp.dao;

import com.arwka.springapp.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom", "Bradberry", "tombrad@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", "Collins", "bobcol@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Mike", "Evans", "mikeevans@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Katy", "Watson", "kwats@gmail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
}
