package be.ucll.webshop.domain.db;

public class UserDatabaseFactory {

    public static UserDatabase getDatabase(String type) {
        switch(type) {
            case "Memory":
                return UsersInMemory.getInstance();
            case "Persistent":
                return new UsersInDerby();
            default:
                return UsersInMemory.getInstance();
        }
    }
}
