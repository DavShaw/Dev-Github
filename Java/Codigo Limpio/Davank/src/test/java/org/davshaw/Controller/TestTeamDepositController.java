package org.davshaw.Controller;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.davshaw.External.ResultPack;
import org.davshaw.Model.derivatedentities.TeamDeposit;
import org.junit.Test;

public class TestTeamDepositController {

  @Test
  public void testValidepositExist() {
    int id = 1;
    ResultPack<Boolean> result = TeamDepositController.depositExist(id);
    assertTrue(result.getResult());
    assertTrue(result.getOkay());
  }


  @Test
  public void testValidGetDeposit() {
    int id = 2;
    ResultPack<TeamDeposit> result = TeamDepositController.getDeposit(id);
    assertNotNull(result.getResult());
    assertInstanceOf(TeamDeposit.class, result.getResult());
    assertTrue(result.getOkay());
  }


  @Test
  public void testValidTotalDeposit() {
    int logId = 302;
    ResultPack<Double> result = TeamDepositController.totalDeposit(logId);
    assertNotNull(result.getResult());
    assertTrue(result.getResult() > 0);
    assertTrue(result.getOkay());
  }

  @Test
  public void testInvalidDepositExist() {
    int id = 21515;
    ResultPack<Boolean> result = TeamDepositController.depositExist(id);
    assertFalse(result.getResult());
    assertTrue(result.getOkay());
  }

  @Test
  public void testInvalidGetDeposit() {
    int id = 2124;
    ResultPack<TeamDeposit> result = TeamDepositController.getDeposit(id);
    assertNull(result.getResult());
    assertFalse(result.getOkay());
  }

  @Test
  public void testInvalidTotalDeposit() {
    int logId = 5021;
    ResultPack<Double> result = TeamDepositController.totalDeposit(logId);
    assertFalse(result.getOkay());
    assertNull(result.getResult());
  }
}
