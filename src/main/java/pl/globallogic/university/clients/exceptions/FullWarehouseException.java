package pl.globallogic.university.clients.exceptions;

public class FullWarehouseException extends RuntimeException {
    public FullWarehouseException(String message) {
        super(message);
    }
}
