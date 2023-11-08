package org.davshaw.Davank;

import java.util.Date;

import org.davshaw.Controller.TeamDebtLogController;
import org.davshaw.Model.derivatedentities.TeamDebtLog;

public class App {
    
    public static void main(String[] args) {
        
        TeamDebtLogController.createLog(1, 1);

    }

}
