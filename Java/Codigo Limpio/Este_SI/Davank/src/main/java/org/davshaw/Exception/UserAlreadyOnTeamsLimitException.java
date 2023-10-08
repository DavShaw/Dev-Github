package org.davshaw.Exception;

public class UserAlreadyOnTeamsLimitException extends RuntimeException {
    public UserAlreadyOnTeamsLimitException() {
        super("User is already joined in the limit teams.");
    }
}
