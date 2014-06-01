package es.unileon.administrationFeeViewer.repository;

import es.unileon.administrationFeeViewer.domain.Account;

/**
 * Data Access Object for the Account object (database access)
 * @author EmanuelIosif
 *
 */
public interface AccountDao {
	
	/**
	 * Accesses the database accounts table and returns Account objects
	 * @return An Account object
	 */
	public Account getAccount();
	
	/**
	 * Injects the Account specified as a parameter in the accounts database table
	 * @param account An Account object
	 */
	public void saveAccount(Account account);

}
