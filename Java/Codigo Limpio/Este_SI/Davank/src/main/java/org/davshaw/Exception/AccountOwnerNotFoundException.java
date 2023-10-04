package org.davshaw.Exception;

public class AccountOwnerNotFoundException extends RuntimeException {
    public AccountOwnerNotFoundException() {
        super("There's not a registered account with this owner DNI.");
    }
}
