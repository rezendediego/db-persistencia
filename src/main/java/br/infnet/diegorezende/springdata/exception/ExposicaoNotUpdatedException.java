package br.infnet.diegorezende.springdata.exception;

public class ExposicaoNotUpdatedException extends RuntimeException{
    public ExposicaoNotUpdatedException() {
    }

    public ExposicaoNotUpdatedException(String message) {
        super(message);
    }
}
