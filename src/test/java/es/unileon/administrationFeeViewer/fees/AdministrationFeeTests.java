package es.unileon.administrationFeeViewer.fees;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the methods contained inside the AdministrationFee class
 * @author EmanuelIosif
 *
 */
public class AdministrationFeeTests {

	/**
	 * AdministrationFee used to invoke the corresponding methods to test
	 */
	private AdministrationFee adminFee;
	
	/**
	 * Initializes the AdministrationFee
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception{
		
		adminFee = new AdministrationFee();
	}
	
	/**
	 * Tests getter and setter for the administrationFeeID attribute
	 */
	@Test
	public void testSetAndGetadminFeeID(){
		
		Integer adminFeeID = new Integer(1);
		assertNull(adminFee.getAdministrationFeeID());
		adminFee.setAdministrationFeeID(adminFeeID);
		assertEquals(adminFeeID, adminFee.getAdministrationFeeID());
		
	}
	
	/**
	 * Tests getter and setter for the modality attribute
	 */
	@Test
	public void testSetAndGetModality(){
		
		String modality = "Cuenta Personal";
		assertEquals("", adminFee.getModality());
		adminFee.setModality(modality);
		assertEquals(modality , adminFee.getModality());
		
	}
	
	/**
	 * Tests getter and setter for the modalityFee attribute
	 */
	@Test
	public void testSetAndGetModalityFee(){
		
		double modalityFee = 38.10;
		assertEquals(0.00, adminFee.getModalityFee(), 0);
		adminFee.setModalityFee(modalityFee);
		assertEquals(modalityFee, adminFee.getModalityFee(), 0);
		
	}
	
	/**
	 * Tests getter and setter for the feePeriod attribute
	 */
	@Test
	public void testSetAndGetFeeperiod(){
		
		String feePeriod = "Trimestral";
		assertEquals("", adminFee.getFeePeriod());
		adminFee.setFeePeriod(feePeriod);
		assertEquals(feePeriod , adminFee.getFeePeriod());
		
	}
	
	/**
	 * Tests getter for the ANUAL_ADMIN_FEE attribute
	 */
	@Test
	public void testGetAnualAdminFee(){
		
		assertEquals(30.00, adminFee.getANUAL_ADMIN_FEE(), 0);
		
	}
	
}
