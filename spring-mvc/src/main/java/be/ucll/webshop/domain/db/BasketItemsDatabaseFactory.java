package be.ucll.webshop.domain.db;

public class BasketItemsDatabaseFactory {

    public static BasketItemDatabase getDatabase(String type) {
        switch(type) {
            case "Memory":
                return BasketItemsInMemory.getInstance();
            case "Persistent":
                return new BasketItemsInDerby();
            default:
                return BasketItemsInMemory.getInstance();
        }
    }
}
