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
        people.add(new Person(++PEOPLE_COUNT, "Tom", "Bradberry", 25, "tombrad@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", "Collins", 53, "bobcol@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Mike", "Evans", 19, "mikeevans@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Katy", "Watson", 18, "kwats@gmail.com"));
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

    public void update(int id, Person person) {
        Person personToUpdate = show(id);
        personToUpdate.setName(person.getName());
        personToUpdate.setSurname(person.getSurname());
        personToUpdate.setAge(person.getAge());
        personToUpdate.setEmail(person.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
