package org.davshaw.Controller;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.util.List;
import org.davshaw.External.ResultPack;
import org.davshaw.Model.pureentities.User;
import org.junit.Test;

public class TestUserController {

  @Test
  public void testValidLogin() {
    Integer userDni = 1245782;
    String password = "Davkisnu";

    ResultPack<Boolean> result = UserController.login(userDni, password);

    assertTrue(result.getOkay());
    assertNull(result.getResult());
  }

  @Test
  public void testInvalidLogin() {
    Integer userDni = 1245782000;
    String password = "Davkisnu";

    ResultPack<Boolean> result = UserController.login(userDni, password);

    assertFalse(result.getOkay());
    assertNull(result.getResult());
  }

  @Test
  public void testValidUser() {
    Integer userDni = 1245782;

    ResultPack<Boolean> result = UserController.userExist(userDni);

    assertTrue(result.getOkay());
    assertTrue(result.getResult());
  }

  @Test
  public void testInvalidUser() {
    Integer userDni = 1245782512;

    ResultPack<Boolean> result = UserController.userExist(userDni);

    assertTrue(result.getOkay());
    assertFalse(result.getResult());
  }

  @Test
  public void testValidGetUser() {
    Integer userDni = 1245782;

    ResultPack<User> result = UserController.getUser(userDni);

    assertTrue(result.getOkay());
    //assertEquals(result.getResult().getDni(), userDni);
    assertInstanceOf(User.class, result.getResult());
  }

  @Test
  public void testInvalidGetUser() {
    Integer userDni = 1245782952;

    ResultPack<User> result = UserController.getUser(userDni);

    assertFalse(result.getOkay());
    assertNull(result.getResult());
  }

  @Test
  public void testValidTeamList() {
    Integer userDni = 1245782;

    ResultPack<List<Integer>> result = UserController.getTeamList(userDni);

    assertTrue(result.getOkay());
    assertInstanceOf(List.class, result.getResult());
  }

  @Test
  public void testValidTeamList2() {
    Integer userDni = 1245782;

    ResultPack<List<Integer>> result = UserController.getTeamList(userDni);

    assertTrue(result.getOkay());
    assertInstanceOf(List.class, result.getResult());
    assertTrue(result.getResult().size() >= 1);
  }

  @Test
  public void testInvalidTeamList() {
    Integer userDni = 124578213;

    ResultPack<List<Integer>> result = UserController.getTeamList(userDni);

    assertFalse(result.getOkay());
    assertNull(result.getResult());
  }
}
