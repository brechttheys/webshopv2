package be.ucll.webshop.domain.service;

import be.ucll.webshop.domain.db.BasketItemDatabase;
import be.ucll.webshop.domain.db.BasketItemsDatabaseFactory;
import be.ucll.webshop.domain.model.BasketItem;
import be.ucll.webshop.domain.model.Product;

import java.util.List;

public class BasketService {

    private BasketItemDatabase baskets;

    public BasketService() {
        baskets = BasketItemsDatabaseFactory.getDatabase("Memory");
    }

    public BasketService(String type) {
        baskets = BasketItemsDatabaseFactory.getDatabase(type);
    }

    public void addItemToBasket(BasketItem item) {
        baskets.addBasketItem(item);
    }

    public void removeItemFromBasket(int id) {
        baskets.removeBasketItemWithId(id);
    }

    public List<Product> getBasketForUser(String username) {
       return baskets.getAllItemsForUser(username);
    }

}
