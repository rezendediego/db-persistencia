package br.infnet.diegorezende.springdata.exception;

public class PinturaNotFoundException extends RuntimeException{
    public PinturaNotFoundException() {
    }

    public PinturaNotFoundException(String message) {
        super(message);
    }
}
