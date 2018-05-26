package be.ucll.webshop.domain.db;

public class ProductDatabaseFactory {

    public static ProductDatabase getDatabase(String type) {
        switch(type) {
            case "Memory":
                return ProductsInMemory.getInstance();
            case "Persistent":
                return new ProductsInDerby();
            default:
                return ProductsInMemory.getInstance();
        }
    }

}
