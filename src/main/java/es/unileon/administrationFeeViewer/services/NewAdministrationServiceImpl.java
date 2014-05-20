package es.unileon.administrationFeeViewer.services;

import es.unileon.administrationFeeViewer.domain.Account;
import es.unileon.administrationFeeViewer.fees.strategy.Context;
import es.unileon.administrationFeeViewer.fees.strategy.concreteStrategies.*;

public class NewAdministrationServiceImpl implements NewAdministrationService{
	
	private Account account;
	
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	
}
