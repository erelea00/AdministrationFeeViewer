package es.unileon.administrationFeeViewer.domain;

import es.unileon.administrationFeeViewer.account.extra.AccountHandler;
import es.unileon.administrationFeeViewer.bank.Bank;
import es.unileon.administrationFeeViewer.client.Client;
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
public class Account {

    /**
     * The logger of the class
     */
    private static final Logger LOG = Logger.getLogger(Account.class.getName());
    /**
     * The account identifier
     */
    private Handler id;

    /**
     * The account balance
     */
    private double balance;
    /**
     * The account titulars
     */
    private final List<Client> titulars;
    /**
     * The account authorizeds
     */
    private final List<Client> authorizeds;

    /**
     * The max account's overdraft ( in positive )
     */
    private float maxOverdraft;

    /**
     * Create a new account
     *
     * @param office (The office of the account)
     *
     * @param bank ( The bank of the office )
     *
     * @param accountnumber (the accountNumber)
     *
     * @throws es.unileon.administrationFeeViewer.handler.MalformedHandlerException
     *
     */
    public Account(Office office, Bank bank, String accountnumber) throws MalformedHandlerException {
        this.id = new AccountHandler(office.getID(), bank.getID(), accountnumber);
        this.balance = 0.0d;
        this.titulars = new ArrayList<>();
        this.authorizeds = new ArrayList<>();
        this.maxOverdraft = 0;
        LOG.info("Create a new account with number " + accountnumber + " office " + office.getID().toString() + " bank " + bank.getID());
    }

    /**
     * Set the max account's overdraft
     *
     * @param maxOverdraft ( the account's overdraft ( in positive ))
     * @return ( true if succes, false otherwise)
     */
    public boolean setMaxOverdraft(float maxOverdraft) {
        if (maxOverdraft >= 0) {
            LOG.info("Change max overdraft to " + maxOverdraft + "\n");
            this.maxOverdraft = maxOverdraft;
            return true;
        }
        return false;
    }

    /**
     *
     * Add a new titular. The client cannot be repeated, that is, two titulars
     * cannot have the same id, because its id is unique. If we try to add a
     * person that is already added the method return false.
     *
     * @param client ( client to add)
     *
     * @return ( true if success, else false )
     */
    public boolean addTitular(Client client) {
        for (int i = 0; i < this.titulars.size(); i++) {
            if (this.titulars.get(i).getId().compareTo(client.getId()) == 0) {
                LOG.error("Cannot add the titular " + client.getId().toString() + " , the titular already exists");
                return false;
            }
        }
        LOG.info(("Add new titular " + client.getId()));
        this.titulars.add(client);
        return true;
    }

    /**
     *
     * Delete a titular. If the titular hadn't been added, the method return
     * false.
     *
     * @see es.unileon.ulebank.handler.Handler}.
     *
     * @param id ( The client id )
     *
     * @return ( true if success, false otherwise )
     */
    public boolean deleteTitular(Handler id) {
        for (int i = 0; i < this.titulars.size(); i++) {
            if (this.titulars.get(i).getId().compareTo(id) == 0) {
                LOG.info("Delete " + id.toString() + " titular");
                this.titulars.remove(i);
                return true;
            }
        }
        LOG.error("Cannot remove the titular " + id.toString() + " because it doesn't exist");
        return false;
    }

    /**
     *
     * Add a new authorized. The authorized cannot be repeated, that is, two
     * titulars cannot have the same id, because its id is unique.If we try to
     * add a person that is already added the method return false.
     *
     *
     * @param authorized ( authorized to add)
     *
     * @return ( true if success, else false )
     */
    public boolean addAuthorized(Client authorized) {
        for (int i = 0; i < this.authorizeds.size(); i++) {
            if (this.authorizeds.get(i).getId().compareTo(authorized.getId()) == 0) {
                LOG.error("Cannot add the authorized " + authorized.getId().toString() + " , the authorized already exists");
                return false;
            }
        }
        LOG.info(("Add new titular " + authorized.getId()));
        return this.authorizeds.add(authorized);
    }

    /**
     *
     * Delete a authorized. If the authorized hadn't been added, the method
     * return false.
     *
     * @see es.unileon.ulebank.handler.Handler}.
     *
     * @param id ( The authorized id )
     *
     * @return ( true if success, else false )
     */
    public boolean deleteAuthorized(Handler id) {
        for (int i = 0; i < this.authorizeds.size(); i++) {
            if (this.authorizeds.get(i).getId().compareTo(id) == 0) {
                LOG.info("Delete " + id.toString() + " authorized");
                this.authorizeds.remove(i);
                return true;
            }
        }
        LOG.error("Cannot remove the authorized " + id.toString() + " because it doesn't exist");
        return false;
    }

    /**
     * Get the account titulars
     *
     * @return ( The titulars )
     */
    public List<Client> getTitulars() {
        return new ArrayList<>(this.titulars);
    }

    /**
     * Get the authorizeds
     *
     * @return ( the authorizeds )
     */
    public List<Client> getAuthorizeds() {
        return new ArrayList<>(this.authorizeds);
    }

    /**
     * Get the account's balance
     *
     * @return (the balance)
     *
     * @author runix
     */
    public final double getBalance() {
        return this.balance;
    }

    /**
     * Get the max account's overdraft
     * 
     * @return (the account's overdraft )
     */
    public final double getMaxOverdraft() {
        return this.maxOverdraft;
    }

    public void doLiquidation(Office office) {
        StringBuilder err = new StringBuilder();
        try {
            AccountHandler ah = new AccountHandler(this.id);
            if (office.getID().compareTo(ah) == 0) {

            } else {
                err.append("Wrong office\n");
            }
        } catch (MalformedHandlerException e) {
            err.append("Error while parsing handler\n");
        }
    }


    /**
     * Get the account ID
     *
     * @return (the account id)
     * @author runix
     */
    public final Handler getID() {
        return this.id;
    }
}
