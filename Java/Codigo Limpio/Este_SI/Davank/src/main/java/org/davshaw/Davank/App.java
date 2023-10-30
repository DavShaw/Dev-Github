package org.davshaw.Davank;

import org.davshaw.Service.Team.GetTeams;

public class App {

  public static void main(String code[]) {

    String teams = GetTeams.getText();
    System.out.println(teams);
  }
}
