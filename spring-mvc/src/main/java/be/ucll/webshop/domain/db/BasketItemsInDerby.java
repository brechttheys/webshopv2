package be.ucll.webshop.domain.db;

import be.ucll.webshop.domain.model.BasketItem;
import be.ucll.webshop.domain.model.Product;

import java.util.List;

public class BasketItemsInDerby implements BasketItemDatabase {
    @Override
    public void addBasketItem(BasketItem item) {

    }

    @Override
    public void removeBasketItemWithId(int id) {

    }

    @Override
    public List<Product> getAllItemsForUser(String username) {
        return null;
    }

}
