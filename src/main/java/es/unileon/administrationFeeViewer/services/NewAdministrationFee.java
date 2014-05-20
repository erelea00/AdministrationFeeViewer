package es.unileon.administrationFeeViewer.services;

import org.hibernate.validator.constraints.NotBlank;

public class NewAdministrationFee {
	
	@NotBlank(message = "Debe elegir una tipo de modalidad.")
	@javax.validation.constraints.Pattern(regexp = "Cuenta Personal|Cuenta Plus|Cuenta Empresa|")
	private String modality ="";

	public String getModality() {
		return modality;
	}

	public void setModality(String modality) {
		this.modality = modality;
	}		

}
