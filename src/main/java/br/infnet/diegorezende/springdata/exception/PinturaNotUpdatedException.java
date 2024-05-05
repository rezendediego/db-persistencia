package br.infnet.diegorezende.springdata.exception;

public class PinturaNotUpdatedException extends RuntimeException{
    public PinturaNotUpdatedException() {
    }

    public PinturaNotUpdatedException(String message) {
        super(message);
    }
}
