package es.unileon.administrationFeeViewer.fees;

/**
 * Interface of all Fees to implement
 * @author EmanuelIosif
 *
 */

public interface Fee{

	/**
	 * Getter for the periodicity of a certain fee
	 * @return periodicity if a fee
	 */
	public String getFeePeriod();
	
}
