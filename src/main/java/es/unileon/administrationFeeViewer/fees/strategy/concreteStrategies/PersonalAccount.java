package es.unileon.administrationFeeViewer.fees.strategy.concreteStrategies;

import es.unileon.administrationFeeViewer.fees.AdministrationFee;
import es.unileon.administrationFeeViewer.fees.strategy.FeeStrategy;

public class PersonalAccount implements FeeStrategy{

	private final String MODALITY ="Cuenta Personal";
	
	private final double MODALITY_FEE = 3;
	
	private final String FEE_PERIOD ="Mensual";
	
	@Override
	public AdministrationFee execute() {
		
		AdministrationFee adminFee = new AdministrationFee();
		
		adminFee.setModality(MODALITY);
		adminFee.setModalityFee(MODALITY_FEE);
		adminFee.setFeePeriod(FEE_PERIOD);
		
		return adminFee;
	}

	

}
