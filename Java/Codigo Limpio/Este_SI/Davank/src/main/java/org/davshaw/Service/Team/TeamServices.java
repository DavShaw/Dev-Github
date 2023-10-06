package org.davshaw.Service.Team;

import java.util.List;

import org.davshaw.Controller.UserController;
import org.davshaw.Exception.UserNotFoundException;

public class TeamServices
{
    
    public static List<Integer> getNonNativeTeams(int userDni)
    {
        try
        {
            //Verify user exist
            if(!(UserController.userExist(userDni)))
            {
                throw new UserNotFoundException();
            }
        }

        catch (Exception e)
        {

        }
        return null;
    }
    
}
