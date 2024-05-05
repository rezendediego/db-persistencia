package br.infnet.diegorezende.springdata.exception;

public class MuseuNotFoundException extends RuntimeException{
    public MuseuNotFoundException() {
    }

    public MuseuNotFoundException(String message) {
        super(message);
    }
}
