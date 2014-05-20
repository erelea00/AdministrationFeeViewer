package es.unileon.administrationFeeViewer.services;

import es.unileon.administrationFeeViewer.bank.Bank;
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
	private Bank bank;
	
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
		
		bank.getOffices().get(0).getAccounts().get(0).setAdminFee(context.executeStrategy());
		
	}

	/**
	 * Getter for the bank attribute
	 */
	public Bank getBank() {
		return bank;
	}
	
	/**
	 * Setter for the bank attribute
	 * @param bank Bank where the office with the account is located
	 */
	public void setBank(Bank bank) {
		this.bank = bank;
	}

	
}
