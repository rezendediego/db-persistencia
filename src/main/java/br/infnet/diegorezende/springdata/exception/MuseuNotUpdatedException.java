package br.infnet.diegorezende.springdata.exception;

public class MuseuNotUpdatedException extends RuntimeException{
    public MuseuNotUpdatedException() {
    }

    public MuseuNotUpdatedException(String message) {
        super(message);
    }
}
