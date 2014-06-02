package es.unileon.administrationFeeViewer.repository;

import es.unileon.administrationFeeViewer.domain.Account;

/**
 * Simulates an Account Data Access Object in memory
 * @author EmanuelIosif
 *
 */
public class InMemoryAccountDao implements AccountDao{

	private Account account;
	
	/**
	 * Constructor that acts as a setter for the account attribute
	 * @param account
	 */
	public InMemoryAccountDao(Account account){
		
		this.account = account;
		
	}
	
	/**
	 * Getter for the account attribute
	 */
	public Account getAccount() {
		
    	return account;
	}
	
	/**
	 * Setter for the account attribute
	 */
	public void saveAccount(Account account) {
		
		this.account = account;
	}

}