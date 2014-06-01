package es.unileon.administrationFeeViewer.fees.strategy.concreteStrategies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.unileon.administrationFeeViewer.fees.AdministrationFee;
import es.unileon.administrationFeeViewer.fees.strategy.FeeStrategy;
import es.unileon.administrationFeeViewer.repository.AdministrationFeeDao;

/**
 * Concrete strategy to be applied to a company account
 * @author EmanuelIosif
 *
 */
@Component
public class CompanyAccount implements FeeStrategy{
	
	@Autowired
    private AdministrationFeeDao administrationFeeDao;
	
	/**
	 * Account modality
	 */
	private final String MODALITY ="Cuenta Empresa";
	
	/**
	 * Account modality fee
	 */
	private final double MODALITY_FEE = 50;
	
	/**
	 * Charge cycle for the current fee
	 */
	private final String FEE_PERIOD ="Semestral";
	
	/**
	 * Creates a be administration fee objects and sets all the attributes
	 */
	@Override
	public AdministrationFee execute() {
		
		AdministrationFee adminFee = administrationFeeDao.getAdministrationFee();
		
		adminFee.setModality(MODALITY);
		adminFee.setModalityFee(MODALITY_FEE);
		adminFee.setFeePeriod(FEE_PERIOD);
		
		administrationFeeDao.saveAdministrationFee(adminFee);
		return administrationFeeDao.getAdministrationFee();
	}
	
	/**
	 * Setter for the administrationFeeDao attribute
	 * @param administrationFeeDao The data access object for the AdministrationFee class
	 */
	public void setAdministrationFeeDao(AdministrationFeeDao administrationFeeDao) {
        this.administrationFeeDao = administrationFeeDao;
    }

}
