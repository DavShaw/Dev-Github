package org.davshaw.Exception;

public class DuplicateUserDNIException extends RuntimeException {
    public DuplicateUserDNIException() {
        super("There's another registered user with the same DNI.");
    }
}
