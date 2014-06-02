package es.unileon.administrationFeeViewer.services;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import es.unileon.administrationFeeViewer.domain.Account;
import es.unileon.administrationFeeViewer.fees.AdministrationFee;
import es.unileon.administrationFeeViewer.fees.strategy.concreteStrategies.CompanyAccount;
import es.unileon.administrationFeeViewer.fees.strategy.concreteStrategies.PersonalAccount;
import es.unileon.administrationFeeViewer.fees.strategy.concreteStrategies.PlusAccount;
import es.unileon.administrationFeeViewer.repository.InMemoryAccountDao;
import es.unileon.administrationFeeViewer.repository.InMemoryAdministrationFeeDao;

/**
 * Class which tests the methods contained inside the NewAdministrationServiceImpl class
 * @author EmanuelIosif
 *
 */
public class NewAdministrationServiceImplTests {
	
	/**
	 * Account that needs to be assigned to the in memory dao
	 */
	private Account account;
	
	/**
	 * Dao used by the AdministrationService to recover the account
	 */
	private InMemoryAccountDao accountDao;
	
	/**
	 * New administrationFee to be assigned to the account
	 */
	private NewAdministrationFee newAdministrationFee;
	
	/**
	 * AdministrationService used to assign the new administration fee to the account
	 */
	private NewAdministrationServiceImpl implementation;
	
	/**
	 * Used to initialize all the fields and make the necessary assignments
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception{
		
		String modality = "Sin Seleccionar";
		double modalityFee = 0;
		String feePeriod = "Sin Seleccionar";
		double balance = 100.00;
		
		account = new Account();
		account.setBalance(balance);
		account.setFeePeriod(feePeriod);
		account.setModality(modality);
		account.setModalityFee(modalityFee);
		
		accountDao = new InMemoryAccountDao(account);
		
		newAdministrationFee = new NewAdministrationFee();
		newAdministrationFee.setModality(modality);
		
		implementation = new NewAdministrationServiceImpl();
		
	}
	
	/**
	 * Tests getter for the account attribute
	 */
	@Test
	public void testGetAccount(){
		
		implementation.setAccountDao(accountDao);
		assertNotNull(implementation.getAccount());
		assertEquals(account, implementation.getAccount());
		
	}
	
	/**
	 * Tests the set new administration method with company account data input
	 */
	@Test
	public void testSetNewAdminFeeWithCompanyAccountData(){
		
		CompanyAccount companyAccount = new CompanyAccount();
		AdministrationFee adminFee = new AdministrationFee();
		InMemoryAdministrationFeeDao adminFeeDao = new InMemoryAdministrationFeeDao(adminFee);
		companyAccount.setAdministrationFeeDao(adminFeeDao);
		
		implementation.setCompanyAccount(companyAccount);
		String modality = "Cuenta Empresa";
		newAdministrationFee.setModality(modality);
		implementation.setAccountDao(accountDao);
		
		assertEquals("Sin Seleccionar", accountDao.getAccount().getModality());
		assertEquals(0, accountDao.getAccount().getModalityFee(), 0);
		assertEquals("Sin Seleccionar", accountDao.getAccount().getFeePeriod());

		
		implementation.setNewAdminFee(newAdministrationFee);
		
		assertEquals("Cuenta Empresa", accountDao.getAccount().getModality());
		assertEquals(50, accountDao.getAccount().getModalityFee(), 0);
		assertEquals("Semestral", accountDao.getAccount().getFeePeriod());
	}
	
	/**
	 * Tests the set new administration method with personal account data input
	 */
	@Test
	public void testSetNewAdminFeeWithPersonalAccountData(){
		
		PersonalAccount personalAccount = new PersonalAccount();
		AdministrationFee adminFee = new AdministrationFee();
		InMemoryAdministrationFeeDao adminFeeDao = new InMemoryAdministrationFeeDao(adminFee);
		personalAccount.setAdministrationFeeDao(adminFeeDao);
		
		implementation.setPersonalAccount(personalAccount);
		String modality = "Cuenta Personal";
		newAdministrationFee.setModality(modality);
		implementation.setAccountDao(accountDao);
		
		assertEquals("Sin Seleccionar", accountDao.getAccount().getModality());
		assertEquals(0, accountDao.getAccount().getModalityFee(), 0);
		assertEquals("Sin Seleccionar", accountDao.getAccount().getFeePeriod());

		
		implementation.setNewAdminFee(newAdministrationFee);
		
		assertEquals("Cuenta Personal", accountDao.getAccount().getModality());
		assertEquals(3, accountDao.getAccount().getModalityFee(), 0);
		assertEquals("Mensual", accountDao.getAccount().getFeePeriod());
	}
	
	/**
	 * Tests the set new administration method with plus account data input
	 */
	@Test
	public void testSetNewAdminFeeWithPlusAccountData(){
		
		PlusAccount plusAccount = new PlusAccount();
		AdministrationFee adminFee = new AdministrationFee();
		InMemoryAdministrationFeeDao adminFeeDao = new InMemoryAdministrationFeeDao(adminFee);
		plusAccount.setAdministrationFeeDao(adminFeeDao);
		
		implementation.setPlusAccount(plusAccount);
		String modality = "Cuenta Plus";
		newAdministrationFee.setModality(modality);
		implementation.setAccountDao(accountDao);
		
		assertEquals("Sin Seleccionar", accountDao.getAccount().getModality());
		assertEquals(0, accountDao.getAccount().getModalityFee(), 0);
		assertEquals("Sin Seleccionar", accountDao.getAccount().getFeePeriod());

		
		implementation.setNewAdminFee(newAdministrationFee);
		
		assertEquals("Cuenta Plus", accountDao.getAccount().getModality());
		assertEquals(20, accountDao.getAccount().getModalityFee(), 0);
		assertEquals("Trimestral", accountDao.getAccount().getFeePeriod());
	}
}
