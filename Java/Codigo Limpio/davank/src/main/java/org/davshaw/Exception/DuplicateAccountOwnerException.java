package org.davshaw.Exception;

public class DuplicateAccountOwnerException extends RuntimeException {

  public DuplicateAccountOwnerException() {
    super("There's another registered account with this owner DNI.");
  }
}
