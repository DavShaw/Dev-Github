package org.davshaw.Service.Loan;

import java.util.List;

import org.davshaw.Controller.TeamLoanController;
import org.davshaw.Model.derivatedentities.TeamLoan;
import org.davshaw.Model.pureentities.Team;
import org.davshaw.Model.pureentities.User;

public class GetLoanReportAsText {
    public static String getText(List<Integer> loanIdReportList) {
        String msg = "";
        for (Integer loanId : loanIdReportList) {
            if (loanId != null) {
                TeamLoan loan = TeamLoanController.getLoan(loanId).getResult();
                User user = loan.getLog().getUser();
                Team team = loan.getLog().getTeam();
                msg += "=-=-=-=-=-=-=-=-=-=-=-=-=";
                msg += "\n";
                msg += "User information";
                msg += "\n";
                msg += "User full name: " + user.getFullName();
                msg += "\n";
                msg += "User Dni: " + user.getDni();
                msg += "\n";
                msg += "._._._._._._._._._._._._._.";
                msg += "\n";
                msg += "Team information";
                msg += "\n";
                msg += "Team name: " + team.getName();
                msg += "\n";
                msg += "Team id: " + team.getId();
                msg += "\n";
                msg += "._._._._._._._._._._._._._.";
                msg += "\n";
                msg += "Loan information";
                msg += "\n";
                msg += "Date: " + loan.getDateTime();
                msg += "\n";
                msg += "Amount: " + loan.getBalance();
                msg += "\n";
                msg += "=-=-=-=-=-=-=-=-=-=-=-=-=";
                msg += "\n";
                msg += "\n";
            }
        }
        if(!(msg.equalsIgnoreCase(""))) {
            return msg;
        }
        return "There's nothing to see";
        
    }
}
