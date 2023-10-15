package org.davshaw.Davank;

import org.davshaw.Controller.AccountController;
import org.davshaw.External.ResultPack;

public class App {

  public static void main(String code[]) {

    ResultPack<Boolean> r1 = AccountController.createAccount(106);
    System.out.println(r1.getOkay());
    System.out.println(r1.getResult());
    System.out.println(r1.getMessage());
  }
}
