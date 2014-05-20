package es.unileon.administrationFeeViewer.services;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Service which is trusted with the action of setting a new addministration fee for an account
 * @author EmanuelIosif
 *
 */
public class NewAdministrationFee {
	
	/**
	 * Modality of the account
	 */
	@NotBlank(message = "Debe elegir una tipo de modalidad.")
	@javax.validation.constraints.Pattern(regexp = "Cuenta Personal|Cuenta Plus|Cuenta Empresa|")
	private String modality ="";

	/**
	 * Getter for the modality attribute
	 * @return modality type for the account
	 */
	public String getModality() {
		return modality;
	}
	
	/**
	 * Setter for the modality attribute
	 * @param modality modality type for the account
	 */
	public void setModality(String modality) {
		this.modality = modality;
	}		

}
