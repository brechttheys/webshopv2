package be.ucll.webshop.domain.db;

import be.ucll.webshop.domain.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;

public class ProductsInDerby implements ProductDatabase {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("webshopPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public ProductsInDerby() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Driver driver = new org.apache.derby.jdbc.ClientDriver();
            DriverManager.registerDriver(driver);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public HashMap<Integer, Product> getProducts() {
        List<Product> productslist = entityManager.createQuery("Select c from Product c", Product.class).getResultList();
        HashMap<Integer, Product> productsout = new HashMap<>();
        for (Product p : productslist) {
            productsout.put(p.getId(),p);
        }
        return productsout;
    }

    @Override
    public void addProduct(Product product) {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }


    @Override
    public void removeProductWithId(int id) {
        Product dbproduct = entityManager.find(Product.class,id);
        entityManager.getTransaction().begin();
        entityManager.remove(dbproduct);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateProduct(int id, Product product) {
        entityManager.getTransaction().begin();
        Product dbproduct = entityManager.find(Product.class,id);
        dbproduct.setName(product.getName());
        dbproduct.setDescription(product.getDescription());
        dbproduct.setPrice(product.getPrice());
        dbproduct.setRating(product.getRating());
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    @Override
    public Product getProduct(int id) {
        return entityManager.find(Product.class,id);
    }

    @Override
    public List<Product> getProductsAsList() {
        List<Product> productslist = entityManager.createQuery("Select c from Product c", Product.class).getResultList();
        return productslist;
    }
}
