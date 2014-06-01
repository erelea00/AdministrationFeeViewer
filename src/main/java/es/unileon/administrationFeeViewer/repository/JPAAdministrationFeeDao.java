package es.unileon.administrationFeeViewer.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.administrationFeeViewer.fees.AdministrationFee;

/**
 * Data Access Object for the AdministrationFee object (database access)
 * @author EmanuelIosif
 *
 */
@Repository(value = "administrationFeeDao")
public class JPAAdministrationFeeDao implements AdministrationFeeDao{

	private EntityManager em = null;
	
	/**
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    /**
	 * Accesses the database administrationfee table and returns AdministrationFee objects
	 * @return An AdministrationFee object
	 */
    @Transactional(readOnly = true)
	public AdministrationFee getAdministrationFee() {
		
    	return (AdministrationFee) em.createQuery("select b from AdministrationFee b order by b.administrationFeeID").getSingleResult();
	}

    /**
	 * Injects the AdministrationFee specified as a parameter in the administrationfees database table
	 * @param fee An AdministrationFee object
	 */
    @Transactional(readOnly = false)
	public void saveAdministrationFee(AdministrationFee fee) {
		
    	em.merge(fee);
	}

}
