package es.unileon.administrationFeeViewer.fees.strategy;

import es.unileon.administrationFeeViewer.fees.AdministrationFee;

public class Context {

	private FeeStrategy feeStrategy;
	
	public Context(FeeStrategy feeStrategy){
		
		this.feeStrategy = feeStrategy;	
		
	}
	
	public AdministrationFee executeStrategy(String modalityOption){
		
		return this.feeStrategy.execute();
		
	}
	
}
