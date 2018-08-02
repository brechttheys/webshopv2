package be.ucll.webshop.domain.db;

import be.ucll.webshop.domain.model.BasketItem;
import be.ucll.webshop.domain.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BasketItemsInMemory implements BasketItemDatabase {

    private static BasketItemsInMemory instance = null;
    private static final AtomicInteger count = new AtomicInteger(0);
    private List<BasketItem> basketitems;

    public BasketItemsInMemory() {
        this.basketitems = new ArrayList<>();
    }

    public static BasketItemsInMemory getInstance() {
        if (instance == null) instance = new BasketItemsInMemory();
        return instance;
    }

    @Override
    public void addBasketItem(BasketItem item) {
        if (item == null) throw new DBException("Added item cannot be null");
        int counter = count.getAndIncrement();
        item.setId(counter);
        basketitems.add(item);
    }

    @Override
    public void removeBasketItemWithId(int id) {
        if (id < 0) throw new DBException("id cannot be smaller than 0");
        for (BasketItem i : basketitems) {
            if (i.getId() == id) {
                basketitems.remove(i);
            }
        }
    }

    @Override
    public List<Product> getAllItemsForUser(String username) {
        List<Product> products = new ArrayList<>();
        ProductDatabase productdb = ProductsInMemory.getInstance();
        for (BasketItem i : basketitems) {
            if (i.getUsername() == username) {
                products.add(productdb.getProduct(i.getProductid()));
            }
        }
        return products;
    }
}
