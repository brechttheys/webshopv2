package be.ucll.webshop.domain.model;

import be.ucll.webshop.domain.model.movie.Movie;
import org.springframework.web.client.RestTemplate;

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
    @Max(value=10,message="{error.rating.span}")
    private int rating;

    private String year;
    private String agerating;
    private String releasedate;
    private String runtime;
    private String genre;
    private String writer;
    private String actors;
    private String poster;

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

    public void setName(String name) {
        this.name = name;
        RestTemplate restTemplate = new RestTemplate();
        Movie movie = restTemplate.getForObject("http://www.omdbapi.com/?t=" + this.getName() + "&apikey=7811224a", Movie.class);
        setYear(movie.getYear());
        setAgerating(movie.getRated());
        setReleasedate(movie.getReleased());
        setRuntime(movie.getRuntime());
        setGenre(movie.getGenre());
        setWriter(movie.getWriter());
        setActors(movie.getActors());
        setPoster(movie.getPoster());
    }

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


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAgerating() {
        return agerating;
    }

    public void setAgerating(String agerating) {
        this.agerating = agerating;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }


}
