package be.ucll.webshop.domain.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String passwordConfirm;
    private String role;


    public Person() {

    }

    public Person(int id, String username, String firstname, String lastname, String password, String passwordConfirm, String role) {
        setId(id);
        setUsername(username);
        setFirstname(firstname);
        setLastname(lastname);
        setPassword(password);
        setPasswordConfirm(passwordConfirm);
        setRole(role);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
