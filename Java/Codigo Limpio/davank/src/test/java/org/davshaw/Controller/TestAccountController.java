package org.davshaw.Controller;

import static org.junit.jupiter.api.Assertions.*;

import org.davshaw.External.ResultPack;
import org.davshaw.Model.pureentities.Account;
import org.junit.jupiter.api.Test;

public class TestAccountController {

  @Test
  public void testValidAccountExist() {
    int ownerDni = 1245782;
    ResultPack<Boolean> result = AccountController.accountExist(ownerDni);
    assertTrue(result.getResult());
    assertTrue(result.getOkay());
  }

  @Test
  public void testValidGetAccount() {
    int ownerDni = 1245782;
    ResultPack<Account> result = AccountController.getAccount(ownerDni);
    assertInstanceOf(Account.class, result.getResult());
    assertTrue(result.getOkay());
  }

  @Test
  public void testValidGetBalance() {
    int ownerDni = 1245782;
    ResultPack<Double> result = AccountController.getBalance(ownerDni);
    assertNotNull(result.getResult());
    assertTrue(result.getOkay());
  }

  @Test
  public void testValidHasEnough() {
    int ownerDni = 1245782;
    double balance = 100.0;
    ResultPack<Boolean> result = AccountController.hasEnough(ownerDni, balance);
    assertTrue(result.getResult());
    assertTrue(result.getOkay());
  }

  @Test
  public void testInvalidAccountExist() {
    int ownerDni = 1245782512;
    ResultPack<Boolean> result = AccountController.accountExist(ownerDni);
    assertFalse(result.getResult());
  }

  @Test
  public void testInvalidGetAccount() {
    int ownerDni = 1245782512;
    ResultPack<Account> result = AccountController.getAccount(ownerDni);
    assertNull(result.getResult());
  }

  @Test
  public void testInvalidGetBalance() {
    int ownerDni = 1245782512;
    ResultPack<Double> result = AccountController.getBalance(ownerDni);
    assertNull(result.getResult());
  }

  @Test
  public void testInvalidHasEnough() {
    int ownerDni = 1245782512;
    double balance = 100.0;
    ResultPack<Boolean> result = AccountController.hasEnough(ownerDni, balance);
    assertFalse(result.getOkay());
    assertNull(result.getResult());
  }
}
