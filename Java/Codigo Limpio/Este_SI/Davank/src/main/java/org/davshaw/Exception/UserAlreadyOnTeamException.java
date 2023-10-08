package org.davshaw.Exception;

public class UserAlreadyOnTeamException extends RuntimeException {
    public UserAlreadyOnTeamException() {
        super("User is already on that team.");
    }
}