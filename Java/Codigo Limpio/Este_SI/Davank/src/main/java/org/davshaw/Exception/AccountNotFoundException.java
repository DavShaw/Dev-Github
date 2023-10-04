package org.davshaw.Exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException() {
        super("Entered account doesn't exist.");
    }
}
