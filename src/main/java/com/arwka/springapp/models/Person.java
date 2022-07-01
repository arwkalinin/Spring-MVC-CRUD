package com.arwka.springapp.models;

import javax.validation.constraints.*;

public class Person {
    private int id;

    @NotEmpty(message = "Name should not be empty.")
    @Size(min = 3, max = 30, message = "Name should be between 3 and 30 characters.")
    private String name;
    @NotEmpty(message = "Surname should not be empty.")
    @Size(min = 3, max = 30, message = "Surname should be between 3 and 30 characters.")
    private String surname;
    @Min(value = 0, message = "Age should be greater than 0")
    @Max(value = 120, message = "Age should be less than 120")
    private int age;
    @NotEmpty(message = "E-mail should not be empty")
    @Email(message = "E-mail should be valid")
    private String email;
    // ----------



    // ----------
    public Person() {}
    public Person(int id, String name, String surname, int age, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
