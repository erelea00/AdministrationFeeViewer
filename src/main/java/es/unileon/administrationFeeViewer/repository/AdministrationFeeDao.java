package es.unileon.administrationFeeViewer.repository;

import es.unileon.administrationFeeViewer.fees.AdministrationFee;

/**
 * Data Access Object for the AdministrationFee object (database access)
 * @author EmanuelIosif
 *
 */
public interface AdministrationFeeDao {
	
	/**
	 * Accesses the database administrationfee table and returns AdministrationFee objects
	 * @return An AdministrationFee object
	 */
	public AdministrationFee getAdministrationFee();
	
	/**
	 * Injects the AdministrationFee specified as a parameter in the administrationfees database table
	 * @param fee An AdministrationFee object
	 */
	public void saveAdministrationFee(AdministrationFee fee);

}
