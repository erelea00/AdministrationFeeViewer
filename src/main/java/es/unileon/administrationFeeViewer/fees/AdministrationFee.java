package es.unileon.administrationFeeViewer.fees;

/**
 * Class representing the administration fee to be applyed to an account
 * @author EmanuelIosif
 *
 */
public class AdministrationFee implements Fee{
	
	/**
	 * Annual fixed administration fee
	 */
	private final double ANUAL_ADMIN_FEE = 30;
	
	/**
	 * Account modality type
	 */
	private String modality ="";
	
	/**
	 * Periodic modality fee
	 */
	private double modalityFee = 0.0;
	
	/**
	 * How often the modality fee is charged
	 */
	private String feePeriod ="";
	
	/**
	 * Getter for the modality attribute
	 * @return account modality
	 */
	public String getModality() {
		return modality;
	}
	
	/**
	 * Setter for the modality attribute
	 * @param modality
	 */
	public void setModality(String modality) {
		this.modality = modality;
	}

	/**
	 * Getter for the modality fee attribute
	 * @return amount charged periodicaly
	 */
	public double getModalityFee() {
		return modalityFee;
	}

	/**
	 * Setter for the modality fee attribute
	 * @param modalityFee
	 */
	public void setModalityFee(double modalityFee) {
		this.modalityFee = modalityFee;
	}

	/**
	 * Getter for the fee period attribute
	 * @return how often the fee is charged
	 */
	public String getFeePeriod() {
		return feePeriod;
	}
	
	/**
	 * Setter for the fee period attribute
	 * @param feePeriod 
	 */
	public void setFeePeriod(String feePeriod) {
		this.feePeriod = feePeriod;
	}

	/**
	 * Getter for the annual fee constant
	 * @return fee charged annually
	 */
	public double getANUAL_ADMIN_FEE() {
		return ANUAL_ADMIN_FEE;
	}
	
	
	
}
