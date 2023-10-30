package org.davshaw.Service.Team;

import java.util.List;

import org.davshaw.Controller.TeamController;
import org.davshaw.Model.pureentities.Team;

public class GetTheWinner {
    
    public static Integer getWinner() {

        Integer teamId = null;
        Double ammount = 0.0;

        List<Integer> teamsId = TeamController
        .getTeamsId()
        .getResult();

        for (Integer id : teamsId) {
            
            Team current = TeamController
            .getTeam(id)
            .getResult();

            if (current.getBalance() > ammount) {
                ammount = current.getBalance();
                teamId = current.getId();
            }
        }
        return (teamId != null) ? teamId : null;
    }


    public static void main(String[] args) {
        Integer winner = getWinner();
        System.out.println(winner);
    }


}
