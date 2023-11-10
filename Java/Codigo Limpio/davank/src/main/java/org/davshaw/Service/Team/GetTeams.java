package org.davshaw.Service.Team;

import java.util.List;

import org.davshaw.Controller.TeamController;
import org.davshaw.Controller.TeamLogController;
import org.davshaw.Model.derivatedentities.TeamLog;
import org.davshaw.Model.pureentities.Team;

public class GetTeams {
    
    public static String getText() {
        
        List<Integer> teamIdList = TeamController.getTeamsId().getResult();
        String msg = "";

        for (Integer teamId : teamIdList) {

            Team team = TeamController
            .getTeam(teamId)
            .getResult();

            List<Integer> teamLogIdList = TeamLogController
            .getLogIdByTeamId(team.getId())
            .getResult();
             
            msg += "===============================";
            msg += "\n";
            msg += "Team name: " + team.getName();
            msg += "\n";
            msg += "Team Id: " + team.getId();
            msg += "\n";
            msg += "Team balance: " + team.getBalance();
            msg += "\n";
            msg += "Team Members:";
            msg += "\n";

            for (Integer teamLogId : teamLogIdList) {

                TeamLog log = TeamLogController
                .getLog(teamLogId)
                .getResult();
                msg += "\n";
                msg += "-> " + log.getUser().getFullName();
            }

            msg += "\n";
            msg += "===============================";
            msg += "\n";
        }
        
        return msg;
    }
    
}
