package es.unileon.administrationFeeViewer.services;

import es.unileon.administrationFeeViewer.domain.Account;
import es.unileon.administrationFeeViewer.fees.strategy.Context;
import es.unileon.administrationFeeViewer.fees.strategy.concreteStrategies.*;

/**
 * Service which sets a new administration fee for the current account
 * @author EmanuelIosif
 *
 */
public class NewAdministrationServiceImpl implements NewAdministrationService{
	
	/**
	 * Bank where the office with the account is located
	 */
	private Account account;
	
	/**
	 * Sets a new administration fee for the current account
	 */
	@Override
	public void setNewAdminFee(NewAdministrationFee newAdminFee) {
		
		Context context = null;
		
		switch (newAdminFee.getModality()){						
			case "Cuenta Personal": context = new Context(new PersonalAccount());
									break;
			case "Cuenta Plus": context = new Context(new PlusAccount());
								break;
			case "Cuenta Empresa": context = new Context(new CompanyAccount());
								   break;									
		}
		
		account.setAdminFee(context.executeStrategy());
		
	}

	/**
	 * Getter for the bank attribute
	 */
	public Account getAccount() {
		return account;
	}
	
	/**
	 * Setter for the bank attribute
	 * @param bank Bank where the office with the account is located
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	
}
