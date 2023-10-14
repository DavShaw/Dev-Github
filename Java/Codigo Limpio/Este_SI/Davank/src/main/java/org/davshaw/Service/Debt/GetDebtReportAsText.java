package org.davshaw.Service.Debt;

import java.util.ArrayList;
import java.util.List;

import org.davshaw.Controller.TeamDebtLogController;
import org.davshaw.Model.derivatedentities.TeamDebtLog;
import org.davshaw.Model.pureentities.Team;
import org.davshaw.Model.pureentities.User;

public class GetDebtReportAsText {

    public static String getText(List<Integer> logIdList) {

        if(logIdList != null && !logIdList.isEmpty()) {

            // Get TeamDebtLog by LogId
            List<TeamDebtLog> teamDebtLogs = new ArrayList<TeamDebtLog>();
            
            for (Integer id : logIdList) {
                TeamDebtLog log = TeamDebtLogController.getLogByLogId(id).getResult();
                if(log != null) {
                    teamDebtLogs.add(log);
                }
            }
            
            if(!(teamDebtLogs.isEmpty())) {

                String msg = "";

                for (TeamDebtLog debt : teamDebtLogs) {
                    
                    Team team = debt.getLog().getTeam();
                    User user = debt.getLog().getUser();

                    msg += "=-=-=-=-=-=-=-=-=-=-=-=-=";
                    msg += "\n";
                    msg += "Debt information";
                    msg += "\n";
                    msg += "Debt Id: " + debt.getId();
                    msg += "\n";
                    msg += "Debt Amount: " + debt.getAmount();
                    msg += "\n";
                    msg += "Debt Lastpayment: " + debt.getLastPayment();
                    msg += "\n";
                    msg += "._._._._._._._._._._._._._.";
                    msg += "\n";
                    msg += "User information:";
                    msg += "\n";
                    msg += "User full name: " + user.getFullName();
                    msg += "\n";
                    msg += "User dni: " + user.getDni();
                    msg += "\n";
                    msg += "._._._._._._._._._._._._._.";
                    msg += "\n";
                    msg += "Team information";
                    msg += "\n";
                    msg += "Team name: " + team.getName();
                    msg += "\n";
                    msg += "Team id: " + team.getId();
                    msg += "\n";
                    msg += "=-=-=-=-=-=-=-=-=-=-=-=-=";
                    msg += "\n";
                    msg += "\n";
                }
                return msg;
            }

            return "There's nothing to see...";
        }
        return "There's nothing to see...";
    }

}
