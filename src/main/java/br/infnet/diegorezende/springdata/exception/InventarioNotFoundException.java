package br.infnet.diegorezende.springdata.exception;

public class InventarioNotFoundException extends RuntimeException{
    public InventarioNotFoundException() {
    }

    public InventarioNotFoundException(String message) {
        super(message);
    }
}
