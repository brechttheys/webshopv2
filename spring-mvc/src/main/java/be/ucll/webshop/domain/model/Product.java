package be.ucll.webshop.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Product {

    @Id
    @GeneratedValue
    @PositiveOrZero(message = "{invalid.negative.number}")
    private int id;

    @NotEmpty(message = "{error.no.name}")
    private String name;
    private String description;
    @PositiveOrZero(message = "{invalid.negative.number}")
    private double price;
    @Min(value=0,message="{error.rating.span}")
    @Max(value=5,message="{error.rating.span}")
    private int rating;

    public Product() {}

    public Product(int id,String name, String description, double price, int rating) {
        setId(id);
        setName(name);
        setDescription(description);
        setPrice(price);
        setRating(rating);
    }

    public Product(String name, String description, double price, int rating) {
        setName(name);
        setDescription(description);
        setPrice(price);
        setRating(rating);
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

    public void setName(String name) { this.name = name; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
