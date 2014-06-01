package es.unileon.administrationFeeViewer.fees;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class representing the administration fee to be applyed to an account
 * @author EmanuelIosif
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="administrationfees")
public class AdministrationFee implements Fee, Serializable{
	
	/**
	 * Represents the administrationnFeeID column in the administrationfees database table
	 */
	@Id
    @Column(name = "administrationFeeID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer administrationFeeID;
	
	/**
	 * Annual fixed administration fee
	 */
	@Column(name = "anualAdminFee")
	private final double ANUAL_ADMIN_FEE = 30;
	
	/**
	 * Account modality type
	 */
	@Column(name = "modality")
	private String modality ="";
	
	/**
	 * Periodic modality fee
	 */
	@Column(name = "modalityFee")
	private double modalityFee = 0.0;
	
	/**
	 * How often the modality fee is charged
	 */
	@Column(name = "feePeriod")
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
	
	/**
	 * Getter for the Administration Fee Id attribute
	 * @return Id of the Administration Fee
	 */
	public Integer getAdministrationFeeID() {
		return administrationFeeID;
	}

	/**
	 * Setter for the Administration Fee Id attribute
	 * @param administrationFeeID Id of the Administration Fee
	 */
	public void setAdministrationFeeID(Integer administrationFeeID) {
		this.administrationFeeID = administrationFeeID;
	}
	
	
	
}
