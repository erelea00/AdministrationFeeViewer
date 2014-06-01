package es.unileon.administrationFeeViewer.repository;

import es.unileon.administrationFeeViewer.fees.AdministrationFee;

public class InMemoryAdministrationFeeDao implements AdministrationFeeDao{

	private AdministrationFee adminFee;
	
	public InMemoryAdministrationFeeDao(AdministrationFee adminFee){
		
		this.adminFee = adminFee;		
	}

	public AdministrationFee getAdministrationFee() {
		
    	return adminFee;
	}

	public void saveAdministrationFee(AdministrationFee adminFee) {
		
		this.adminFee = adminFee;
	}

}