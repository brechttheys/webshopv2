package be.ucll.webshop.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Role {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private Set<Person> users;

    public Role(int id, String name) {
        setId(id);
        setName(name);
    }

    public Role() {
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

    @ManyToMany(mappedBy = "roles")
    public Set<Person> getUsers() {
        return users;
    }

    public void setUsers(Set<Person> users) {
        this.users = users;
    }
}
