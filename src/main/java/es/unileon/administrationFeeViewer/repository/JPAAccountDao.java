package es.unileon.administrationFeeViewer.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.administrationFeeViewer.domain.Account;

/**
 * Data Access Object for the Account object (database access)
 * @author EmanuelIosif
 *
 */
@Repository(value = "accountDao")
public class JPAAccountDao implements AccountDao{

	private EntityManager em = null;
	
	/**
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    /**
	 * Accesses the database accounts table and returns Account objects
	 * @return An Account object
	 */
    @Transactional(readOnly = true)
	public Account getAccount() {
		
    	return (Account) em.createQuery("select a from Account a order by a.accountID").getSingleResult();
	}

    /**
	 * Injects the Account specified as a parameter in the accounts database table
	 * @param account An Account object
	 */
    @Transactional(readOnly = false)
	public void saveAccount(Account account) {
		
    	em.merge(account);
	}

}
