package org.davshaw.Controller;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.davshaw.External.ResultPack;
import org.davshaw.Model.derivatedentities.TeamDebtLog;
import org.junit.Test;

public class TestDebtLogController {

  @Test
  public void testValidLogExist() {
    int id = 1;
    ResultPack<Boolean> result = TeamDebtLogController.logExist(id);
    assertTrue(result.getResult());
    assertTrue(result.getOkay());
  }

  @Test
  public void testValidGetLog() {
    int id = 1;
    ResultPack<TeamDebtLog> result = TeamDebtLogController.getLog(id);
    assertNotNull(result.getResult());
    assertInstanceOf(TeamDebtLog.class, result.getResult());
  }

  @Test
  public void testValidGetLogByLogId() {
    int logId = 1;
    ResultPack<TeamDebtLog> result = TeamDebtLogController.getLogByLogId(logId);
    assertNotNull(result.getResult());
    assertInstanceOf(TeamDebtLog.class, result.getResult());
    assertEquals(logId, result.getResult().getLogId());
    assertTrue(result.getOkay());
  }

  @Test
  public void testValidGetCurrentDebt() {
    int id = 2;
    ResultPack<Double> result = TeamDebtLogController.getCurrentDebt(id);
    assertNotNull(result.getResult());
    assertTrue(result.getResult() == 40000);
    assertTrue(result.getOkay());
  }

  @Test
  public void testInvalidGetCurrentDebt() {
    int id = 51251;
    ResultPack<Double> result = TeamDebtLogController.getCurrentDebt(id);
    assertNull(result.getResult());
    assertFalse(result.getOkay());
  }

  @Test
  public void testInvalidLogExist() {
    int id = 1512515;
    ResultPack<Boolean> result = TeamDebtLogController.logExist(id);
    assertFalse(result.getResult());
    assertTrue(result.getOkay());
  }

  @Test
  public void testInvalidGetLog() {
    int id = 51252;
    ResultPack<TeamDebtLog> result = TeamDebtLogController.getLog(id);
    assertNull(result.getResult());
    assertFalse(result.getOkay());
  }

  @Test
  public void testInvalidGetLogByLogId() {
    int logId = 8521;
    ResultPack<TeamDebtLog> result = TeamDebtLogController.getLogByLogId(logId);
    assertNull(result.getResult());
    assertFalse(result.getOkay());
  }
}
