package be.ucll.webshop.domain.db;

public class DBException extends RuntimeException {

    public DBException(String message){
        super(message);
    }

    public DBException(String message, Exception e){
        super(message, e);
    }
}
