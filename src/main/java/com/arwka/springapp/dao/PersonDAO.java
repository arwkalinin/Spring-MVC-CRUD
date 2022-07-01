package com.arwka.springapp.dao;

import com.arwka.springapp.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/crudapp_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";
    private static Connection connection;
    //
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //
    public List<Person> index() {
        List<Person> people = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setSurname(resultSet.getString("surname"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));

                people.add(person);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return people;
    }
    //
    public Person show(int id) {
        Person person = null;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM Person WHERE id = ?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setSurname(resultSet.getString("surname"));
            person.setAge(resultSet.getInt("age"));
            person.setEmail(resultSet.getString("email"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
    }
    //
    public void save(Person person) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO Person (name, surname, age, email) VALUES(?, ?, ?, ?)");

            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getSurname());
            preparedStatement.setInt(3, person.getAge());
            preparedStatement.setString(4, person.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //
    public void update(int id, Person updatedPerson) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE Person SET name=?, surname=?, age=?, email=? WHERE id = ?");

            preparedStatement.setString(1, updatedPerson.getName());
            preparedStatement.setString(2, updatedPerson.getSurname());
            preparedStatement.setInt(3, updatedPerson.getAge());
            preparedStatement.setString(4, updatedPerson.getEmail());
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM Person WHERE id = ?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
