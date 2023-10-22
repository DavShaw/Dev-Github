package org.davshaw.Service.Account;

import org.davshaw.Controller.AccountController;
import org.davshaw.Controller.UserController;
import org.davshaw.External.ResultPack;

public class GetDepositReportList {
    
    public String getText(int userDni) {
        ResultPack<Boolean> r1 = UserController.userExist(userDni);
        ResultPack<Boolean> r2 = AccountController.accountExist(userDni);
        if(r1.getResult() && r2.getResult()) {
            //Get account number
            //Depostit, withdraw, transfer, has been got!
            int accountNumber = AccountController.getAccountNumber(userDni).getResult();
        }
        return "There's nothing to see...";
    }
}
