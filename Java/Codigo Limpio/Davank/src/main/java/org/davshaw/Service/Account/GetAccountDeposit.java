package org.davshaw.Service.Account;

import java.util.ArrayList;
import java.util.List;

import org.davshaw.Controller.AccountDepositController;
import org.davshaw.Model.derivatedentities.AccountDeposit;


public class GetAccountDeposit {
    
    public static String getText(List<Integer> depositIdList) {

        if(depositIdList != null && !depositIdList.isEmpty()) {

            // Get AccountDeposit by Id
            List<AccountDeposit> AccountDeposits = new ArrayList<AccountDeposit>();
            
            for (Integer id : depositIdList) {
                
                AccountDeposit log = AccountDepositController.getDeposit(id).getResult();

                if(log != null) {
                    AccountDeposits.add(log);
                }

            }
            
            if(!(AccountDeposits.isEmpty())) {

                String msg = "";

                for (AccountDeposit deposit : AccountDeposits) {

                    msg += "=======================";
                    msg += "\n";
                    msg += "Deposit information:";
                    msg += "\n";
                    msg += "Type: Physically";
                    msg += "\n";
                    msg += "From: N/A";
                    msg += "\n";
                    msg += "To (Account): " + deposit.getAccountId();
                    msg += "\n";
                    msg += "To (User): " + deposit.getAccount().getOwner().getFullName();
                    msg += "\n";
                    msg += "Date: " + deposit.getDateTime();
                    msg += "\n";
                    msg += "Deposit Id: " + deposit.getId();
                    msg += "\n";
                    msg += "=======================";
                }
                return msg;
            }

            return "There's nothing to see...";
        }
        return "There's nothing to see...";
    }
}
