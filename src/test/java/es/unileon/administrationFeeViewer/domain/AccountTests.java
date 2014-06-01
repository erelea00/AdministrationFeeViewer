package es.unileon.administrationFeeViewer.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AccountTests {

	private Account account;
	
	@Before
	public void setUp() throws Exception{
		
		account = new Account();
		
	}
	
	@Test
	public void testSetAndGetAccountID(){
		
		Integer accountID = new Integer(1);
		assertNull(account.getAccountID());
		account.setAccountID(accountID);
		assertEquals(accountID, account.getAccountID());
		
	}
	
	@Test
	public void testSetAndGetBalance(){
		
		double balance = 138.22;
		assertEquals(0, account.getBalance(), 0);
		account.setBalance(balance);
		assertEquals(balance, account.getBalance(), 0);
		
	}
	
	@Test
	public void testSetAndGetModality(){
		
		String modality = "Cuenta Personal";
		assertEquals("", account.getModality());
		account.setModality(modality);
		assertEquals(modality , account.getModality());
		
	}
	
	@Test
	public void testSetAndGetModalityFee(){
		
		double modalityFee = 38.10;
		assertEquals(0.00, account.getModalityFee(), 0);
		account.setModalityFee(modalityFee);
		assertEquals(modalityFee, account.getModalityFee(), 0);
		
	}
	
	@Test
	public void testSetAndGetFeeperiod(){
		
		String feePeriod = "Trimestral";
		assertEquals("", account.getFeePeriod());
		account.setFeePeriod(feePeriod);
		assertEquals(feePeriod , account.getFeePeriod());
		
	}
	
	@Test
	public void testGetAnualAdminFee(){
		
		assertEquals(30.00, account.getANUAL_ADMIN_FEE(), 0);
		
	}
}
