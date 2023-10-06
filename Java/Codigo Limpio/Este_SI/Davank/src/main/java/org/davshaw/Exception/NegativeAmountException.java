package org.davshaw.Exception;

public class NegativeAmountException extends IllegalArgumentException {

    public NegativeAmountException() {
        super("The amount cannot be negative.");
    }

}