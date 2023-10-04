package org.davshaw.Exception;

public class UserNotInAnyTeamException extends RuntimeException {
    public UserNotInAnyTeamException() {
        super("User is not in any team.");
    }
}
