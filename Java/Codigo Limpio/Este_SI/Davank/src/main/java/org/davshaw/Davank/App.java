package org.davshaw.Davank;

import java.util.List;
import org.davshaw.Controller.UserController;
import org.davshaw.Service.Debt.GetDebtReportAsText;

public class App {

  public static void main(String code[]) {
    List<Integer> listofLogs = UserController.getLogIdReport(106).getResult();
    String r = GetDebtReportAsText.getText(listofLogs);
    System.out.println(r);
  }
}
