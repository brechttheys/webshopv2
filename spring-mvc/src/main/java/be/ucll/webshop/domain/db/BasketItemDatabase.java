package be.ucll.webshop.domain.db;

import be.ucll.webshop.domain.model.BasketItem;
import be.ucll.webshop.domain.model.Product;

import java.util.List;

public interface BasketItemDatabase {

    void addBasketItem(BasketItem item);
    void removeBasketItemWithId(int id);
    List<Product> getAllItemsForUser(String username);
}
