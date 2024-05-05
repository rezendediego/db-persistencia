package br.infnet.diegorezende.springdata.exception;

public class PintorNotUpdatedException extends RuntimeException{
    public PintorNotUpdatedException() {
    }

    public PintorNotUpdatedException(String message) {
        super(message);
    }
}
