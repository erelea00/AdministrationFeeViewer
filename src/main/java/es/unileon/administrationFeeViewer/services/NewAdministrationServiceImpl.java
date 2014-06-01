package es.unileon.administrationFeeViewer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.unileon.administrationFeeViewer.domain.Account;
import es.unileon.administrationFeeViewer.fees.strategy.Context;
import es.unileon.administrationFeeViewer.fees.strategy.concreteStrategies.*;
import es.unileon.administrationFeeViewer.repository.AccountDao;

/**
 * Service which sets a new administration fee for the current account
 * @author EmanuelIosif
 *
 */

@Component
public class NewAdministrationServiceImpl implements NewAdministrationService{
	
	/**
	 * Account Data Access Object 
	 */
	@Autowired
    private AccountDao accountDao;
	
	/**
	 * Company Account Administration Fee Strategy
	 */
	@Autowired
    private CompanyAccount companyAccount;
	
	/**
	 * Personal Account Administration Fee Strategy
	 */
	@Autowired
    private PersonalAccount personalAccount;
	
	/**
	 * Plus Account Administration Strategy
	 */
	@Autowired
    private PlusAccount plusAccount;
	
	/**
	 * Sets a new administration fee for the current account
	 */
	@Override
	public void setNewAdminFee(NewAdministrationFee newAdminFee) {
		
		Context context = new Context();  //initializes the context that invokes the corresponding strategy
		
		//Decides which strategy to use based on the ComboBox Input in the Web View 
		switch (newAdminFee.getModality()){						
			case "Cuenta Personal": context.setStrategy(personalAccount);
									break;
			case "Cuenta Plus": context.setStrategy(plusAccount);;
								break;
			case "Cuenta Empresa": context.setStrategy(companyAccount);;
								   break;									
		}
		
		//Sets the modality related attributes in the account and injects it in the database
		Account newAccount = accountDao.getAccount();
		newAccount.setModality(context.executeStrategy().getModality());
		newAccount.setModalityFee(context.executeStrategy().getModalityFee());
		newAccount.setFeePeriod(context.executeStrategy().getFeePeriod());
		accountDao.saveAccount(newAccount);
		
	}
	
	/**
	 * Setter for the Account Data Access Object 
	 * @param accountDao
	 */
	public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

	/**
	 * Getter for the account attribute
	 */
	public Account getAccount() {
		return accountDao.getAccount();
	}
	
	/**
	 * Getter for companyAccount attribute
	 * @return companyAccount strategy
	 */
	public CompanyAccount getCompanyAccount() {
		return companyAccount;
	}

	/**
	 * Setter for companyAccount attribute
	 * @param companyAccount companyAccount strategy
	 */
	public void setCompanyAccount(CompanyAccount companyAccount) {
		this.companyAccount = companyAccount;
	}
	
	/**
	 * Getter for personalAccount attribute
	 * @return personalAccount Strategy
	 */
	public PersonalAccount getPersonalAccount() {
		return personalAccount;
	}
	
	/**
	 * Setter for personalAccount attribute
	 * @param personalAccount personalAccount Strategy
	 */
	public void setPersonalAccount(PersonalAccount personalAccount) {
		this.personalAccount = personalAccount;
	}
	
	/**
	 * Getter for plusAccount attribute
	 * @return plusAccount Strategy
	 */
	public PlusAccount getPlusAccount() {
		return plusAccount;
	}

	/**
	 * Setter for plusAccount attribute
	 * @param plusAccount plusAccount Strategy
	 */
	public void setPlusAccount(PlusAccount plusAccount) {
		this.plusAccount = plusAccount;
	}

	
}
