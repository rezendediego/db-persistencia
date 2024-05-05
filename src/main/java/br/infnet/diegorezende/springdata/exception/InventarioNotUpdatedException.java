package br.infnet.diegorezende.springdata.exception;

public class InventarioNotUpdatedException extends RuntimeException{
    public InventarioNotUpdatedException() {
    }

    public InventarioNotUpdatedException(String message) {
        super(message);
    }
}
