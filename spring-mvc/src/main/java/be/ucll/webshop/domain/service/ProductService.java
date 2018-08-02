package be.ucll.webshop.domain.service;

import be.ucll.webshop.domain.db.ProductDatabase;
import be.ucll.webshop.domain.db.ProductDatabaseFactory;
import be.ucll.webshop.domain.model.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class ProductService {
    private ProductDatabase products;

    public ProductService() {
        products = ProductDatabaseFactory.getDatabase("Memory");
    }

    public ProductService(String type) {
        products = ProductDatabaseFactory.getDatabase(type);
    }

    public HashMap<Integer, Product> getProducts() {
        return products.getProducts();
    }

    public void addProduct(Product product) {
        products.addProduct(product);
    }

    public Product getProduct(int id) {
        return products.getProduct(id);
    }

    public void updateProduct(int id, Product product) {
        products.updateProduct(id,product);
    }

    public void removeProduct(int id) {
        products.removeProductWithId(id);
    }

    public List<Product> getProductsAsList() { return products.getProductsAsList(); }
}
