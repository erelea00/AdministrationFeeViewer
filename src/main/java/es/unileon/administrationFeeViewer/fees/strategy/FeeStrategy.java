package es.unileon.administrationFeeViewer.fees.strategy;

import es.unileon.administrationFeeViewer.fees.AdministrationFee;

/**
 * Interface to be implemented by all fee concrete strategies
 * @author EmanuelIosif
 *
 */
public interface FeeStrategy {
	
	/**
	 * Puts the strategy in motion
	 * @return A new administration fee
	 */
	public AdministrationFee execute();
	
}
