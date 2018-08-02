package be.ucll.webshop.domain.service;

import be.ucll.webshop.domain.db.UserDatabase;
import be.ucll.webshop.domain.db.UserDatabaseFactory;
import be.ucll.webshop.domain.db.UsersInDerby;
import be.ucll.webshop.domain.model.Person;

import java.util.List;
import java.util.Set;

public class UserService {

    private UserDatabase userdb;

    public UserService(String type) { userdb  = UserDatabaseFactory.getDatabase(type);}

    public UserService() {
        userdb = UserDatabaseFactory.getDatabase("Memory");
    }

    public void saveUser(Person user) {
        this.userdb.addUser(user);
    }

    public List<Person> getUsers() {
        return this.userdb.getUsers();
    }

    public Person findUserByUsername(String username) {
        return userdb.findByUsername(username);
    }
}
