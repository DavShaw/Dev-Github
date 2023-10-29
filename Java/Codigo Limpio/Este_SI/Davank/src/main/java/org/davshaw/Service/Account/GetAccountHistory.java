package org.davshaw.Service.Account;

import java.util.List;

import org.davshaw.Controller.AccountController;
import org.davshaw.Controller.AccountDepositController;
import org.davshaw.Controller.AccountTransferController;
import org.davshaw.Controller.AccountWithdrawController;
import org.davshaw.Controller.UserController;
import org.davshaw.External.ResultPack;

public class GetAccountHistory {
    
    public static String getText(int userDni) {
        
        ResultPack<Boolean> r1 = UserController.userExist(userDni);
        ResultPack<Boolean> r2 = AccountController.accountExist(userDni);
        
        
        if(r1.getResult() && r2.getResult()) {

            String depositMessage = "";
            String transferMessage = "";
            String withdrawMessage = "";

            List<Integer> l1 = AccountDepositController
            .getDepositReport(userDni)
            .getResult();
            
            List<Integer> l2 = AccountTransferController
            .getTransferReport(userDni)
            .getResult();
            
            List<Integer> l3 = AccountWithdrawController
            .getWithdrawReport(userDni)
            .getResult();

            if (!l1.isEmpty()) {
                depositMessage += GetAccountDeposit.getText(l1);
            }
            
            if (!l2.isEmpty()) {
                transferMessage += GetAccountTransfer.getText(l2);
            }
            
            if (!l3.isEmpty()) {
                withdrawMessage += GetAccountWithdraw.getText(l3);
            }
            

            return depositMessage + transferMessage + withdrawMessage;
        }

        return "There's nothing to see...";
    }

}
