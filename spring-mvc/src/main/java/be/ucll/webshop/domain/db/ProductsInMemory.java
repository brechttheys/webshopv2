package be.ucll.webshop.domain.db;

import be.ucll.webshop.domain.model.Product;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductsInMemory implements ProductDatabase {

    private static ProductsInMemory instance = null;
    private static final AtomicInteger count = new AtomicInteger(0);
    private HashMap<Integer, Product> products;

    public ProductsInMemory() {
        this.products = new HashMap<>();
        addProduct(new Product("Test1","Random",21.5,5));
        addProduct(new Product("Test2","Random",21.5,5));
    }

    public static ProductsInMemory getInstance() {
        if (instance == null) instance = new ProductsInMemory();
        return instance;
    }

    @Override
    public HashMap<Integer, Product> getProducts() {
        return this.products;
    }

    @Override
    public void addProduct(Product product) {
        int counter = count.getAndIncrement();
        product.setId(counter);
        products.put(counter,product);
    }


    @Override
    public void removeProductWithId(int id) {
        products.remove(id);
    }

    @Override
    public void updateProduct(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public Product getProduct(int id) {
        return products.get(id);
    }


}
