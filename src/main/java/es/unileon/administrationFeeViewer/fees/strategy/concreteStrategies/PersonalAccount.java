package es.unileon.administrationFeeViewer.fees.strategy.concreteStrategies;

import es.unileon.administrationFeeViewer.fees.AdministrationFee;
import es.unileon.administrationFeeViewer.fees.strategy.FeeStrategy;

/**
 * Concrete strategy to be applied to a Personal account
 * @author EmanuelIosif
 *
 */
public class PersonalAccount implements FeeStrategy{
	
	/**
	 * Account modality
	 */
	private final String MODALITY ="Cuenta Personal";
	
	/**
	 * Account modality fee
	 */
	private final double MODALITY_FEE = 3;
	
	/**
	 * Charge cycle for the current fee
	 */
	private final String FEE_PERIOD ="Mensual";
	
	/**
	 * Creates a be administration fee objects and sets all the attributes
	 */
	@Override
	public AdministrationFee execute() {
		
		AdministrationFee adminFee = new AdministrationFee();
		
		adminFee.setModality(MODALITY);
		adminFee.setModalityFee(MODALITY_FEE);
		adminFee.setFeePeriod(FEE_PERIOD);
		
		return adminFee;
	}

	

}
