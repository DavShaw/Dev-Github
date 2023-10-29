package org.davshaw.Davank;

import org.davshaw.Controller.AccountController;
import org.davshaw.Controller.AccountDepositController;
import org.davshaw.Controller.AccountTransferController;
import org.davshaw.Controller.AccountWithdrawController;
import org.davshaw.Controller.UserController;
import org.davshaw.Model.derivatedentities.AccountDeposit;
import org.davshaw.Service.Account.GetAccountDeposit;
import org.davshaw.Service.Account.GetAccountHistory;
import org.davshaw.Service.Account.GetAccountTransfer;
import org.davshaw.Service.Account.GetAccountWithdraw;

public class App {

  public static void main(String code[]) {

    System.out.println("que sale: " + GetAccountHistory.getText(1067592686));
  }
}
