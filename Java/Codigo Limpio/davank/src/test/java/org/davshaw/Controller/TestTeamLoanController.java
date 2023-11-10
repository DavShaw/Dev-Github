package org.davshaw.Controller;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.davshaw.External.ResultPack;
import org.davshaw.Model.derivatedentities.TeamLoan;
import org.junit.Test;

public class TestTeamLoanController {

  @Test
  public void testValidLoanExist() {
    int id = 1;
    ResultPack<Boolean> result = TeamLoanController.loanExist(id);
    assertTrue(result.getResult());
    assertTrue(result.getOkay());
  }

  @Test
  public void testValidGetLoan() {
    int id = 1;
    ResultPack<TeamLoan> result = TeamLoanController.getLoan(id);
    assertNotNull(result.getResult());
    assertInstanceOf(TeamLoan.class, result.getResult());
    assertTrue(result.getOkay());
  }

  @Test
  public void testValidGetLoanReport() {
    int userDni = 1022678;
    ResultPack<List<Integer>> result = TeamLoanController.getLoanReport(
      userDni
    );
    assertNotNull(result.getResult());
    assertInstanceOf(List.class, result.getResult());
    assertTrue(result.getOkay());
  }

  @Test
  public void testInvalidLoanExist() {
    int id = 51251222;
    ResultPack<Boolean> result = TeamLoanController.loanExist(id);
    assertFalse(result.getResult());
    assertTrue(result.getOkay());
  }

  @Test
  public void testInvalidGetLoan() {
    int id = 51251222;
    ResultPack<TeamLoan> result = TeamLoanController.getLoan(id);
    assertNull(result.getResult());
    assertFalse(result.getOkay());
  }

  @Test
  public void testInvalidGetLoanReport() {
    int userDni = 95251;
    ResultPack<List<Integer>> result = TeamLoanController.getLoanReport(
      userDni
    );
    assertNull(result.getResult());
    assertFalse(result.getOkay());
  }
}
