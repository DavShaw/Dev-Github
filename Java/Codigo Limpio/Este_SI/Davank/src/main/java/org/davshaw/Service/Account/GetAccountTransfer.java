package org.davshaw.Service.Account;

import java.util.ArrayList;
import java.util.List;
import org.davshaw.Controller.AccountTransferController;
import org.davshaw.Model.derivatedentities.AccountTransfer;

public class GetAccountTransfer {
    
    public static String getText(List<Integer> transferIdList) {

        if(transferIdList != null && !transferIdList.isEmpty()) {

            // Get AccountTransfer by Id
            List<AccountTransfer> accountTransfers = new ArrayList<AccountTransfer>();
            
            for (Integer id : transferIdList) {
                
                AccountTransfer transfer = AccountTransferController.getTransfer(id).getResult();

                if(transfer != null) {
                    accountTransfers.add(transfer);
                }

            }
            
            if(!(accountTransfers.isEmpty())) {

                String msg = "";

                for (AccountTransfer log : accountTransfers) {

                    msg += "=======================";
                    msg += "\n";
                    msg += "Transfer information";
                    msg += "\n";
                    msg += "Transfer id: " + log.getId();
                    msg += "\n";
                    msg += "Date: " + log.getDateTime();
                    msg += "\n";
                    msg += "Balance: " + log.getBalance();
                    msg += "\n";
                    msg += "Origin information";
                    msg += "\n";
                    msg += "From (Account):" + log.getOriginAccountNumber();
                    msg += "\n";
                    msg += "From (User): " + log.getOriginAccount().getOwner().getFullName();
                    msg += "\n";
                    msg += "Destination information";
                    msg += "\n";
                    msg += "To (Account):" + log.getDestinationAccountNumber();
                    msg += "\n";
                    msg += "To (User): " + log.getDestinationAccount().getOwner().getFullName();
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
