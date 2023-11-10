package org.davshaw.Exception;

public class HaveNotDepositEnoughException extends RuntimeException {

  public HaveNotDepositEnoughException() {
    super("The user hasn't deposited enough money for the requested loan.");
  }
}
