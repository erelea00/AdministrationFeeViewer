package es.unileon.administrationFeeViewer.services;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class NewAdministrationFeeTests {

	private NewAdministrationFee newAdminFee;
	
	@Before
	public void setUp() throws Exception{
		
		newAdminFee = new NewAdministrationFee();
		
	}
	
	@Test
	public void testSetAndGetModality(){
		
		String modality = "Cuenta Personal";
		assertEquals("", newAdminFee.getModality());
		newAdminFee.setModality(modality);
		assertEquals(modality , newAdminFee.getModality());
		
	}
	
}
