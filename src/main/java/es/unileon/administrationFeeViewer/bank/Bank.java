/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.administrationFeeViewer.bank;

import es.unileon.administrationFeeViewer.account.extra.AccountHandler;
import es.unileon.administrationFeeViewer.account.extra.TransactionException;
import es.unileon.administrationFeeViewer.domain.Account;
import es.unileon.administrationFeeViewer.handler.Handler;
import es.unileon.administrationFeeViewer.handler.MalformedHandlerException;
import es.unileon.administrationFeeViewer.office.Office;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 *
 * @author runix
 */
public class Bank {

    private final List<Office> offices;
    private Handler bankID;
    private static final Logger LOG = Logger.getLogger(Account.class.getName());

    public Bank(Handler bankID) throws MalformedHandlerException {
        this.bankID = new BankHandler(bankID.toString());
        this.offices = new ArrayList<>();

    }

    public Handler getID() {
        return this.bankID;
    }

    public boolean addOffice(Office office) {
        if (office != null) {
            for (int i = 0; i < offices.size(); ++i) {
                if (offices.get(i).getID().compareTo(office.getID()) == 0) {
                    return false;
                }
            }
            return this.offices.add(office);
        }
        return false;
    }

    public boolean removeOffice(Handler office) {
        boolean removed = false;
        if (office != null) {
            for (int i = 0; i < offices.size() && !removed; ++i) {
                if (offices.get(i).getID().compareTo(office) == 0) {
                    this.offices.remove(i);
                    removed = true;
                }
            }
        }
        return removed;
    }

    public void doTransaction(Handler destine) throws MalformedHandlerException, TransactionException {
        StringBuilder error = new StringBuilder();
        if (true) {
            AccountHandler handler = new AccountHandler(destine);
            Handler bank = handler.getBankHandler();
            if (this.bankID.compareTo(bank) == 0) {
                Handler office = handler.getOfficeHandler();
                boolean found = false;
                for (int i = 0; i < this.offices.size() && !found; i++) {
                    if (this.offices.get(i).getID().compareTo(office) == 0) {
                        found = true;;
                    }
                }
                if (!found) {
                    error.append("Error, office not found\n");
                }
            }
            
        } 

        if (error.length() > 0) {
            LOG.error("Bank id " + this.bankID + " error : " + error.toString());
            throw new TransactionException(error.toString());
        }
    }
}
