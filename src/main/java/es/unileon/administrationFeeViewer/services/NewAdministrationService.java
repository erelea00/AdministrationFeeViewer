package es.unileon.administrationFeeViewer.services;

import es.unileon.administrationFeeViewer.bank.Bank;

/**
 * Interface which all administration services must implement
 * @author EmanuelIosif
 *
 */
public interface NewAdministrationService {
	
	/**
	 * Sets a new administration fee for the account
	 * @param newAdminFee
	 */
	public void setNewAdminFee(NewAdministrationFee newAdminFee);
	
	/**
	 * Getter for a bank attribute
	 * @return The bank where the office with the account is located
	 */
	public Bank getBank();

}
