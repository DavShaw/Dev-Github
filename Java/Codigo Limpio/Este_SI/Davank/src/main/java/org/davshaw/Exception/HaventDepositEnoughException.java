package org.davshaw.Exception;

public class HaventDepositEnoughException extends RuntimeException {
    public HaventDepositEnoughException() {
        super("The user hasn't deposited enough money for the requested loan.");
    }
}
