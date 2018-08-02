package be.ucll.webshop.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class BasketItem {

    @Id
    @GeneratedValue
    private int id;
    private String username;
    private int productid;

    public BasketItem() {

    }

    public BasketItem(int id, String username, int productid) {
        setId(id);
        setUsername(username);
        setProductid(productid);
    }

    public BasketItem(String username, int productid) {
        setId(0);
        setUsername(username);
        setProductid(productid);
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

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }
}
