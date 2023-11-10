package org.davshaw.Controller;

import static org.junit.jupiter.api.Assertions.*;

import org.davshaw.External.ResultPack;
import org.davshaw.Model.pureentities.Team;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestTeamController {


  @Test
  public void testValidCreateTeam() {
    ResultPack<Boolean> result = TeamController.createTeam("Test Team");
    assertNull(result.getResult());
    assertTrue(result.getOkay());
  }

  @Test
  public void testInvalidCreateTeam() {
    ResultPack<Boolean> result = TeamController.createTeam(null);
    assertNull(result.getResult());
    assertFalse(result.getOkay());
  }

  @Test
  public void testValidTeamExist() {
    int id = 1;
    ResultPack<Boolean> result = TeamController.teamExist(id);
    assertTrue(result.getResult());
    assertTrue(result.getOkay());
  }

  @Test
  public void testInvalidTeamExist() {
    int id = 999;
    ResultPack<Boolean> result = TeamController.teamExist(id);
    assertFalse(result.getResult());
    assertTrue(result.getOkay());
  }

  @Test
  public void testValidGetTeam() {
    int id = 1;
    ResultPack<Team> result = TeamController.getTeam(id);
    assertNotNull(result.getResult());
    assertInstanceOf(Team.class, result.getResult());
    assertTrue(result.getOkay());
  }

  @Test
  public void testInvalidGetTeam() {
    int id = 999;
    ResultPack<Team> result = TeamController.getTeam(id);
    assertNull(result.getResult());
    assertFalse(result.getOkay());
  }

  @Test
  public void testValidGetTeamsId() {
    ResultPack<List<Integer>> result = TeamController.getTeamsId();
    assertNotNull(result.getResult());
    assertTrue(result.getOkay());
  }

  @Test
  public void testValidDeleteTeam() {
    int id = 452;
    ResultPack<Boolean> result = TeamController.deleteTeam(id);
    assertNull(result.getResult());
    assertTrue(result.getOkay());
  }

  @Test
  public void testInvalidDeleteTeam() {
    int id = 122;
    ResultPack<Boolean> result = TeamController.deleteTeam(id);
    assertNull(result.getResult());
    assertFalse(result.getOkay());
  }
}