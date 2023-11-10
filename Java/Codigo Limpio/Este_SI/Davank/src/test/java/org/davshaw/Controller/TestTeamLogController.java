package org.davshaw.Controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.davshaw.External.ResultPack;
import org.davshaw.Model.derivatedentities.TeamLog;

public class TestTeamLogController {

  @Test
  public void testValidLogExist() {
    int id = 102;
    ResultPack<Boolean> result = TeamLogController.logExist(id);
    assertTrue(result.getResult());
    assertTrue(result.getOkay());
  }

  @Test
  public void testValidGetLog() {
    int id = 102;
    ResultPack<TeamLog> result = TeamLogController.getLog(id);
    assertNotNull(result.getResult());
    assertTrue(result.getOkay());
    assertInstanceOf(TeamLog.class, result.getResult());
  }

  @Test
  public void testValidGetLogIdByTeamId() {
    int teamId = 2;
    ResultPack<List<Integer>> result = TeamLogController.getLogIdByTeamId(teamId);
    assertNotNull(result.getResult());
    assertTrue(result.getOkay());
    assertInstanceOf(List.class, result.getResult());
  }

  @Test
  public void testValidUserOnTeam() {
    int userDni = 4578862;
    int teamId = 2;
    ResultPack<Boolean> result = TeamLogController.userOnTeam(userDni, teamId);
    assertTrue(result.getResult());
    assertTrue(result.getOkay());
  }

  @Test
  public void testInvalidLogExist() {
    int id = 512525;
    ResultPack<Boolean> result = TeamLogController.logExist(id);
    assertFalse(result.getResult());
  }

  @Test
  public void testInvalidGetLog() {
    int id = 512525;
    ResultPack<TeamLog> result = TeamLogController.getLog(id);
    assertNull(result.getResult());
  }

  @Test
  public void testInvalidGetLogIdByTeamId() {
    int teamId = 51251;
    ResultPack<List<Integer>> result = TeamLogController.getLogIdByTeamId(teamId);
    assertNull(result.getResult());
    assertFalse(result.getOkay());
  }

  @Test
  public void testInvalidUserOnTeam() {
    int userDni = 0512015;
    int teamId = 512515;
    ResultPack<Boolean> result = TeamLogController.userOnTeam(userDni, teamId);
    assertFalse(result.getOkay());
    assertFalse(result.getResult());
  }

}