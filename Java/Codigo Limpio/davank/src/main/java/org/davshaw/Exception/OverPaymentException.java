package org.davshaw.Exception;

public class OverPaymentException extends RuntimeException {

  public OverPaymentException() {
    super("The payment amount exceeds the outstanding debt.");
  }
}
