package org.davshaw.Exception;

public class TeamNotFoundException extends RuntimeException {

  public TeamNotFoundException() {
    super("There's not a registered team with this id.");
  }
}
