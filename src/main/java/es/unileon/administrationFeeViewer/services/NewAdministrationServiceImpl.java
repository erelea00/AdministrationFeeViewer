package es.unileon.administrationFeeViewer.services;

import es.unileon.administrationFeeViewer.bank.Bank;
import es.unileon.administrationFeeViewer.fees.strategy.Context;
import es.unileon.administrationFeeViewer.fees.strategy.concreteStrategies.*;

public class NewAdministrationServiceImpl implements NewAdministrationService{
	
	private Bank bank;
	
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

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	
}
