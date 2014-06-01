package es.unileon.administrationFeeViewer.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class representing the bank account - Conversion to database "accounts" table
 * @author EmanuelIosif
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="accounts")
public class Account implements Serializable{

	/**
	 * Represents accountID column in the accounts database
	 */
	@Id
	@Column(name="accountID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountID;

    /**
     * The account balance
     */
	@Column(name = "balance")
    private double balance;
    
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
	 * Getter for the accountID attribute
	 * @return The id of the account
	 */
    public Integer getAccountID() {
		return accountID;
	}
    
    /** 
     * Setter for the accountID attribute
     * @param accountID The id for the account
     */
	public void setAccountID(Integer accountID) {
		this.accountID = accountID;
	}

	/**
     * Get the account's balance
     *
     * @return (the balance)
     *
     * @author runix
     */
    public final double getBalance() {
        return this.balance;
    }
    
    /**
     * Setter for account balance attribute
     */
    public void setBalance(double balance){
    	this.balance = balance;
    }

    /**
     * Get the account ID
     *
     * @return (the account id)
     * @author runix
     */
	
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
