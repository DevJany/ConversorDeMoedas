package br.com.devjany.conversordemoedas.exception;

public class ApiConnectionException extends Exception {
    private final int statusCode;

    public ApiConnectionException(String message) {
        super(message);
        this.statusCode = 0;
    }

    public ApiConnectionException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public ApiConnectionException(String message, Throwable cause) {
        super(message, cause);
        this.statusCode = 0;
    }

    public int getStatusCode() {
        return statusCode;
    }
}