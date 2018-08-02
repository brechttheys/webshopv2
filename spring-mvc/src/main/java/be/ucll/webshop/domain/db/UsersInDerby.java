package be.ucll.webshop.domain.db;
import be.ucll.webshop.domain.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.List;

public class UsersInDerby implements UserDatabase {


    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("webshopPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public UsersInDerby() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Driver driver = new org.apache.derby.jdbc.ClientDriver();
            DriverManager.registerDriver(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> getUsers() {
        List<Person> userslist = entityManager.createQuery("Select c from Person c", Person.class).getResultList();
        return userslist;
    }

    @Override
    public void addUser(Person user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }


    @Override
    public void removeUserWithId(int id) {
    }

    @Override
    public void updateUser(int id, Person user) {
    }

    @Override
    public Person getUser(int id) {
        return null;
    }

    @Override
    public Person findByUsername(String username) {
        return null;
    }
}
