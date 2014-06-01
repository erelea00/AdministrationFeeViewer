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

public class NewAdministrationServiceImplTests {

	private Account account;
	private InMemoryAccountDao accountDao;
	private NewAdministrationFee newAdministrationFee;
	private NewAdministrationServiceImpl implementation;
	
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
	
	@Test
	public void testGetAccount(){
		
		implementation.setAccountDao(accountDao);
		assertNotNull(implementation.getAccount());
		assertEquals(account, implementation.getAccount());
		
	}
	
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
