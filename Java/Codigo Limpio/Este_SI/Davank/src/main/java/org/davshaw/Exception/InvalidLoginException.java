package org.davshaw.Exception;

public class InvalidLoginException extends RuntimeException {
    public InvalidLoginException() {
        super("Login or password are not valid.");
    }
}
