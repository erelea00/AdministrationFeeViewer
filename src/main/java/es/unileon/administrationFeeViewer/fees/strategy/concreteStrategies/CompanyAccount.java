package es.unileon.administrationFeeViewer.fees.strategy.concreteStrategies;

import es.unileon.administrationFeeViewer.fees.AdministrationFee;
import es.unileon.administrationFeeViewer.fees.strategy.FeeStrategy;

public class CompanyAccount implements FeeStrategy{

	private final String MODALITY ="Cuenta Empresa";
	
	private final double MODALITY_FEE = 50;
	
	private final String FEE_PERIOD ="Semestral";
	
	@Override
	public AdministrationFee execute() {
		
		AdministrationFee adminFee = new AdministrationFee();
		
		adminFee.setModality(MODALITY);
		adminFee.setModalityFee(MODALITY_FEE);
		adminFee.setFeePeriod(FEE_PERIOD);
		
		return adminFee;
	}

}
