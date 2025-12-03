package br.edu.ufop.web.sales.exception;

public class UseCaseException extends RuntimeException {
    public UseCaseException(String message) {
        super(message);
    }
}