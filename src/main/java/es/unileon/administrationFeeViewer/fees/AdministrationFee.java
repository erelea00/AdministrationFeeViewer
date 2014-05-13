package es.unileon.administrationFeeViewer.fees;

public class AdministrationFee {
		
	private final double ANUAL_ADMIN_FEE = 30;
	
	private String modality ="";
	
	private double modalityFee = 0.0;
	
	private String feePeriod ="";

	public String getModality() {
		return modality;
	}

	public void setModality(String modality) {
		this.modality = modality;
	}

	public double getModalityFee() {
		return modalityFee;
	}

	public void setModalityFee(double modalityFee) {
		this.modalityFee = modalityFee;
	}

	public String getFeePeriod() {
		return feePeriod;
	}

	public void setFeePeriod(String feePeriod) {
		this.feePeriod = feePeriod;
	}

	public double getANUAL_ADMIN_FEE() {
		return ANUAL_ADMIN_FEE;
	}
	
	
	
}
