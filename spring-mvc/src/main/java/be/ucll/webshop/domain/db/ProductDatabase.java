package be.ucll.webshop.domain.db;

import be.ucll.webshop.domain.model.Product;

import java.util.HashMap;
import java.util.List;

public interface ProductDatabase {

    HashMap<Integer, Product> getProducts();
    void addProduct(Product product);
    void removeProductWithId(int id);
    void updateProduct(int id, Product product);
    Product getProduct(int id);
    List<Product> getProductsAsList();

}
