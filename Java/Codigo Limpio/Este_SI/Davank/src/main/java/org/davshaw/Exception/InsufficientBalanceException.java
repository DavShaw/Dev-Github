package org.davshaw.Exception;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException() {
        super("There's not enough balance.");
    }
}
