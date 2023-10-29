package org.davshaw.Service.Account;

import java.util.ArrayList;
import java.util.List;

import org.davshaw.Controller.AccountWithdrawController;
import org.davshaw.Model.derivatedentities.AccountWithdrawal;

public class GetAccountWithdraw {
    
    public static String getText(List<Integer> withdrawIdList) {

        if(withdrawIdList != null && !withdrawIdList.isEmpty()) {

            // Get AccountTransfer by Id
            List<AccountWithdrawal> withdrawIdLists = new ArrayList<AccountWithdrawal>();
            
            for (Integer id : withdrawIdList) {
                
                AccountWithdrawal withdraw = AccountWithdrawController.getWithdrawal(id).getResult();

                if(withdraw != null) {
                    withdrawIdLists.add(withdraw);
                }

            }
            
            if(!(withdrawIdLists.isEmpty())) {

                String msg = "";

                for (AccountWithdrawal log : withdrawIdLists) {

                    msg += "=======================";
                    msg += "\n";
                    msg += "Withdraw information";
                    msg += "\n";
                    msg += "Id: " + log.getId();
                    msg += "\n";
                    msg += "Date: " + log.getDateTime();
                    msg += "\n";
                    msg += "Balance: " + log.getBalance();
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
