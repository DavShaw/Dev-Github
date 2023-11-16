package org.davshaw.Service.Team;

import java.util.List;

import org.davshaw.Controller.TeamController;
import org.davshaw.Controller.UserController;
import org.davshaw.Model.pureentities.Team;

public class GetTeamReportAsText {
    public static String getText(int userDni) {
        List<Integer> teamLogId = UserController.getTeamList(userDni).getResult();
        if(!(teamLogId.isEmpty()) && teamLogId != null) {
            String msg = "";
            for (Integer id : teamLogId) {
                Team team = TeamController.getTeam(id).getResult();
                
                msg += "=-=-=-=-=-=-=-=-=-=-=-=-=";
                msg += "\n";
                msg += "Team name: " + team.getName();
                msg += "\n";
                msg += "Team id: " + team.getId();
                msg += "\n";
                msg += "Team balance: " + team.getBalance();
                msg += "\n";
                msg += "=-=-=-=-=-=-=-=-=-=-=-=-=";
                msg += "\n";
                msg += "\n";
            }
            return msg;

        }
        return "There's nothing to see...";
    }
}
