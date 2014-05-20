package es.unileon.administrationFeeViewer.fees.strategy;

import es.unileon.administrationFeeViewer.fees.AdministrationFee;

/**
 * Class which represents the context for the Administration Fee Strategy Patter
 * @author EmanuelIosif
 *
 */
public class Context {
	
	/**
	 * Fee strategy to be applied
	 */
	private FeeStrategy feeStrategy;
	
	/**
	 * Constructor class
	 * @param feeStrategy Fee strategy to be applied
	 */
	public Context(FeeStrategy feeStrategy){
		
		this.feeStrategy = feeStrategy;	
		
	}
	
	/**
	 * Puts the strategy actions in motion
	 * @return A new administration fee
	 */
	public AdministrationFee executeStrategy(){
		
		return this.feeStrategy.execute();
		
	}
	
}
