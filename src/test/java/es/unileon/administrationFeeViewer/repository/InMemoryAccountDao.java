package es.unileon.administrationFeeViewer.repository;

import es.unileon.administrationFeeViewer.domain.Account;

public class InMemoryAccountDao implements AccountDao{

	private Account account;
	
	public InMemoryAccountDao(Account account){
		
		this.account = account;
		
	}

	public Account getAccount() {
		
    	return account;
	}

	public void saveAccount(Account account) {
		
		this.account = account;
	}

}