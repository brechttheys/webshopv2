package be.ucll.webshop.domain.db;

import be.ucll.webshop.domain.model.Person;
import be.ucll.webshop.domain.model.Role;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class UsersInMemory implements UserDatabase {

    private static UsersInMemory instance = null;
    private static final AtomicInteger count = new AtomicInteger(0);
    private List<Person> users;

    public UsersInMemory() {
        this.users = new ArrayList<>();
    }

    public static UsersInMemory getInstance() {
        if (instance == null) instance = new UsersInMemory();
        Person p1 = new Person(0,"Admin","Brecht","Theys","1234","1234","ADMIN");
        Person p2 = new Person(0, "User","Brecht","Theys","1234","1234","USER");
        instance.addUser(p1);
        instance.addUser(p2);
        return instance;
    }



    @Override
    public List<Person> getUsers() {
        return this.users;
    }

    @Override
    public void addUser(Person user) {
        int counter = count.getAndIncrement();
        user.setId(counter);
        users.add(user);
    }

    @Override
    public void removeUserWithId(int id) {
        for (Person p : users) {
            if (p.getId() == id) {
                users.remove(p);
            }
        }
    }

    @Override
    public void updateUser(int id, Person user) {
        for (Person p : users) {
            if (p.getId() == id) {
                user.setId(p.getId());
                p = user;
            }
        }
    }

    @Override
    public Person getUser(int id) {
        for (Person p : users) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Person findByUsername(String username) {
        for (Person p : users) {
            if (p.getUsername().equals(username)) {
                return p;
            }
        }
        return null;
    }
}
