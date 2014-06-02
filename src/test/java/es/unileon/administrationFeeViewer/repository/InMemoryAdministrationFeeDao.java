package es.unileon.administrationFeeViewer.repository;

import es.unileon.administrationFeeViewer.fees.AdministrationFee;

/**
 * Simulates an AdministrationFee Data Access Object in memory
 * @author EmanuelIosif
 *
 */
public class InMemoryAdministrationFeeDao implements AdministrationFeeDao{

	private AdministrationFee adminFee;
	
	/**
	 * Constructor which acts as a setter for the adminFee attribute
	 * @param adminFee
	 */
	public InMemoryAdministrationFeeDao(AdministrationFee adminFee){
		
		this.adminFee = adminFee;		
	}
	
	/**
	 * Getter for the adminFee attribute
	 */
	public AdministrationFee getAdministrationFee() {
		
    	return adminFee;
	}
	
	/**
	 * Setter for the adminFee attribute
	 */
	public void saveAdministrationFee(AdministrationFee adminFee) {
		
		this.adminFee = adminFee;
	}

}