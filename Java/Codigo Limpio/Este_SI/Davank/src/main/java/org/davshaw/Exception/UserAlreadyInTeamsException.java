package org.davshaw.Exception;

public class UserAlreadyInTeamsException extends RuntimeException {
    public UserAlreadyInTeamsException() {
        super("User is already joined in the limit teams.");
    }
}
