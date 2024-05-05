package br.infnet.diegorezende.springdata.exception;

public class PintorNotFoundException extends RuntimeException{
    public PintorNotFoundException() {
    }

    public PintorNotFoundException(String message) {
        super(message);
    }
}
