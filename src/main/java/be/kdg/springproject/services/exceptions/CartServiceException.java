package be.kdg.springproject.services.exceptions;

public class CartServiceException extends RuntimeException{
    public CartServiceException(String message) { super(message); }
}
