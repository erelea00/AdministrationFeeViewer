package es.unileon.administrationFeeViewer.services;

import es.unileon.administrationFeeViewer.bank.Bank;

public interface NewAdministrationService {
	
	public void setNewAdminFee(NewAdministrationFee newAdminFee);
	
	public Bank getBank();

}
