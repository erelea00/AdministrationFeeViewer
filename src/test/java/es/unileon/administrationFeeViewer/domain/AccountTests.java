package es.unileon.administrationFeeViewer.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Class which tests the methods contained inside the Account class
 * @author EmanuelIosif
 *
 */
public class AccountTests {
	
	/**
	 * Account upon which all the methods are invoked
	 */
	private Account account;
	
	/**
	 * Initializes the Account 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception{
		
		account = new Account();
		
	}
	
	/**
	 * Tests getter and setter for the accountID attribute
	 */
	@Test
	public void testSetAndGetAccountID(){
		
		Integer accountID = new Integer(1);
		assertNull(account.getAccountID());
		account.setAccountID(accountID);
		assertEquals(accountID, account.getAccountID());
		
	}
	
	/**
	 * Tests getter and setter for the balance attribute
	 */
	@Test
	public void testSetAndGetBalance(){
		
		double balance = 138.22;
		assertEquals(0, account.getBalance(), 0);
		account.setBalance(balance);
		assertEquals(balance, account.getBalance(), 0);
		
	}
	
	/**
	 * Tests getter and setter for the modality attribute
	 */
	@Test
	public void testSetAndGetModality(){
		
		String modality = "Cuenta Personal";
		assertEquals("", account.getModality());
		account.setModality(modality);
		assertEquals(modality , account.getModality());
		
	}
	
	/**
	 * Tests getter and setter for the modalityFee attribute
	 */
	@Test
	public void testSetAndGetModalityFee(){
		
		double modalityFee = 38.10;
		assertEquals(0.00, account.getModalityFee(), 0);
		account.setModalityFee(modalityFee);
		assertEquals(modalityFee, account.getModalityFee(), 0);
		
	}
	
	/**
	 * Tests getter and setter for the feePeriod attribute
	 */
	@Test
	public void testSetAndGetFeePeriod(){
		
		String feePeriod = "Trimestral";
		assertEquals("", account.getFeePeriod());
		account.setFeePeriod(feePeriod);
		assertEquals(feePeriod , account.getFeePeriod());
		
	}
	
	/**
	 * Tests getter for the ANUAL_ADMIN_FEE aconstant
	 */
	@Test
	public void testGetAnualAdminFee(){
		
		assertEquals(30.00, account.getANUAL_ADMIN_FEE(), 0);
		
	}
}
