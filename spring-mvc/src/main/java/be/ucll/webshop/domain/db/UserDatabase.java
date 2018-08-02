package be.ucll.webshop.domain.db;

import be.ucll.webshop.domain.model.Person;

import java.util.List;

public interface UserDatabase {

    public List<Person> getUsers();
    public void addUser(Person user);
    public void removeUserWithId(int id);
    public void updateUser(int id, Person user);
    public Person getUser(int id);
    public Person findByUsername(String username);
}
