package es.unileon.administrationFeeViewer.services;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Class which tests the methods contained inside the NewAdministrationFee class
 * @author EmanuelIosif
 *
 */
public class NewAdministrationFeeTests {

	/**
	 * Used to invoke the methods to be tested
	 */
	private NewAdministrationFee newAdminFee;
	
	/**
	 * Initializes the NewAdministrationFee field
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception{
		
		newAdminFee = new NewAdministrationFee();
		
	}
	
	/**
	 * Tests the getter and setter for the modality attribute
	 */
	@Test
	public void testSetAndGetModality(){
		
		String modality = "Cuenta Personal";
		assertEquals("", newAdminFee.getModality());
		newAdminFee.setModality(modality);
		assertEquals(modality , newAdminFee.getModality());
		
	}
	
}
