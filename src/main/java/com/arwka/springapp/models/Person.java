package com.arwka.springapp.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name should not be empty.")
    @Size(min = 3, max = 30, message = "Name should be between 3 and 30 characters.")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Surname should not be empty.")
    @Size(min = 3, max = 30, message = "Surname should be between 3 and 30 characters.")
    @Column(name = "surname")
    private String surname;

    @Min(value = 0, message = "Age should be greater than 0")
    @Max(value = 120, message = "Age should be less than 120")
    @Column(name = "age")
    private int age;

    @NotEmpty(message = "E-mail should not be empty")
    @Email(message = "E-mail should be valid")
    @Column(name = "email")
    private String email;

    // Country, City, postal code (6nums)
    // Russia, Moscow, 123456
    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}",
            message = "Your address should be in this format: Country, City, postal code (6nums)")
    @Column(name = "address")
    private String address;
    // ----------



    // ----------
    public Person() {}
    public Person(String name, String surname, int age, String email, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
