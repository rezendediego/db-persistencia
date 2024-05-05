package br.infnet.diegorezende.springdata.exception;

public class ExposicaoNotFoundException extends RuntimeException{
    public ExposicaoNotFoundException() {
    }

    public ExposicaoNotFoundException(String message) {
        super(message);
    }
}
