/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.administrationFeeViewer.office;

import es.unileon.administrationFeeViewer.account.extra.AccountHandler;
import es.unileon.administrationFeeViewer.account.extra.TransactionException;
import es.unileon.administrationFeeViewer.bank.Bank;
import es.unileon.administrationFeeViewer.domain.Account;
import es.unileon.administrationFeeViewer.handler.Handler;
import es.unileon.administrationFeeViewer.handler.MalformedHandlerException;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 *
 * @author runix
 */
public class Office {

    private final List<Account> accounts;
    private Handler id;
    private final Bank bank;
    private static final Logger LOG = Logger.getLogger(Account.class.getName());
    private long nextAccountNumber;
    public static final long MAX_ACCOUNT_NUMBER = 1000000000l - 1;

    public Office(Handler id, Bank bank) {
        this.accounts = new ArrayList<>();
        this.id = id;
        this.bank = bank;
        this.nextAccountNumber = 0;
    }

    public boolean addAccount(Account account) {
        return this.accounts.add(account);
    }

    public Handler getID() {
        return this.id;
    }

    public void doTransaction(Handler destine) throws TransactionException, MalformedHandlerException {
        boolean finish = false;
        StringBuilder error = new StringBuilder();
        if (destine != null) {
            AccountHandler handler = new AccountHandler(destine);
            if (handler.getBankHandler().compareTo(this.bank.getID()) == 0 && handler.getOfficeHandler().compareTo(this.id) == 0) {
                for (int i = 0; i < accounts.size() && !finish; i++) {
                    if (accounts.get(i).getID().compareTo(destine) == 0) {                       
                        finish = true;
                    }
                }
            } else {
            }
        } else {
            error.append(("The transaction cannot be null or destination be null"));
        }

        if (error.length() > 0) {
            LOG.error("Office id " + this.id + " error : " + error.toString());
            throw new TransactionException(error.toString());
        }
    }

    public synchronized String getNewAccountNumber() {
        String accountNumber;
        if (this.nextAccountNumber == MAX_ACCOUNT_NUMBER) {
            accountNumber = "";
        } else {
            accountNumber = String.format("%010d", this.nextAccountNumber++);
        }
        return accountNumber;
    }

    public List<Account> getAccounts() {
        return this.accounts;
    }
}
