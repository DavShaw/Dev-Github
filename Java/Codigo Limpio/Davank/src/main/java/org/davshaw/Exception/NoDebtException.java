package org.davshaw.Exception;

public class NoDebtException extends RuntimeException {

  public NoDebtException() {
    super("The user has no outstanding debts.");
  }
}
