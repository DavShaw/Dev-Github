package org.davshaw.Exception;

public class RecordNotFoundException extends RuntimeException {

  public RecordNotFoundException() {
    super("There's not a register with this id.");
  }
}
