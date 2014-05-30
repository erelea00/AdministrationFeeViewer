package es.unileon.administrationFeeViewer.domain;

import es.unileon.administrationFeeViewer.fees.AdministrationFee;
import es.unileon.administrationFeeViewer.handler.Handler;
import java.io.Serializable;

/**
 * Class representing the bank account
 * @author EmanuelIosif
 *
 */
public class Account implements Serializable{

    /**
	 *  Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

    /**
     * The account identifier
     */
    private Handler id;

    /**
     * The account balance
     */
    private double balance;

    /**
     * The max account's overdraft ( in positive )
     */
    private float maxOverdraft;
    
    /**
     * Administration fee to be applied 
     */
    private AdministrationFee adminFee = null;
    
    /**
     * Empty Account Constructor
     */
    public Account(){
    	
    }

    /**
     * Set the max account's overdraft
     *
     * @param maxOverdraft ( the account's overdraft ( in positive ))
     * @return ( true if success, false otherwise)
     */
    public boolean setMaxOverdraft(float maxOverdraft) {
        if (maxOverdraft >= 0) {
            this.maxOverdraft = maxOverdraft;
            return true;
        }
        return false;
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


    /**
     * Get the account ID
     *
     * @return (the account id)
     * @author runix
     */
    public final Handler getID() {
        return this.id;
    }

	public AdministrationFee getAdminFee() {
		return adminFee;
	}

	public void setAdminFee(AdministrationFee adminFee) {
		this.adminFee = adminFee;
	}
    
}
