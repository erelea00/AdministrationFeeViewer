package es.unileon.administrationFeeViewer.fees;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class AdministrationFeeTests {

	private AdministrationFee adminFee;
	
	@Before
	public void setUp() throws Exception{
		
		adminFee = new AdministrationFee();
	}
	
	@Test
	public void testSetAndGetadminFeeID(){
		
		Integer adminFeeID = new Integer(1);
		assertNull(adminFee.getAdministrationFeeID());
		adminFee.setAdministrationFeeID(adminFeeID);
		assertEquals(adminFeeID, adminFee.getAdministrationFeeID());
		
	}
	
	@Test
	public void testSetAndGetModality(){
		
		String modality = "Cuenta Personal";
		assertEquals("", adminFee.getModality());
		adminFee.setModality(modality);
		assertEquals(modality , adminFee.getModality());
		
	}
	
	@Test
	public void testSetAndGetModalityFee(){
		
		double modalityFee = 38.10;
		assertEquals(0.00, adminFee.getModalityFee(), 0);
		adminFee.setModalityFee(modalityFee);
		assertEquals(modalityFee, adminFee.getModalityFee(), 0);
		
	}
	
	@Test
	public void testSetAndGetFeeperiod(){
		
		String feePeriod = "Trimestral";
		assertEquals("", adminFee.getFeePeriod());
		adminFee.setFeePeriod(feePeriod);
		assertEquals(feePeriod , adminFee.getFeePeriod());
		
	}
	
	@Test
	public void testGetAnualAdminFee(){
		
		assertEquals(30.00, adminFee.getANUAL_ADMIN_FEE(), 0);
		
	}
	
}
