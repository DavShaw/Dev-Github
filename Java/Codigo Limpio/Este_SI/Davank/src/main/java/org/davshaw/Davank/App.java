package org.davshaw.Davank;

import java.util.List;

import org.davshaw.Controller.AccountDepositController;
import org.davshaw.Controller.AccountTransferController;
import org.davshaw.Controller.AccountWithdrawController;
import org.davshaw.External.ResultPack;

public class App {

  public static void main(String code[]) {

    ResultPack<List<Integer>> r1 = AccountTransferController.getTransferReport(1067592686);
    System.out.println(r1.getMessageFormatted());
  }
}
