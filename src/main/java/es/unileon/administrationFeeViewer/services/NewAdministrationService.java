package es.unileon.administrationFeeViewer.services;

import es.unileon.administrationFeeViewer.domain.Account;

public interface NewAdministrationService {
	
	public void setNewAdminFee(NewAdministrationFee newAdminFee);
	
	public Account getAccount();

}
