package es.unileon.administrationFeeViewer.web;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.administrationFeeViewer.services.NewAdministrationService;
import es.unileon.administrationFeeViewer.services.NewAdministrationServiceImpl;

/**
 * Class which tests the methods contained inside the SetModalityController class
 * @author EmanuelIosif
 *
 */
public class SetModalityControllerTests {
	
	/**
	 * Controller used to invoke the methods to be tested
	 */
	private SetModalityController modalityController;
	
	/**
	 * Initializes the controller field
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception{
		
		modalityController = new SetModalityController();
		
	}
	
	/**
	 * Tests getter and setter for the newAdministrationService field
	 */
	@Test
	public void testSetAndGetNewAdministrationService(){
		
		NewAdministrationService newAdminService = new NewAdministrationServiceImpl();
		assertNull(modalityController.getNewAdministrationService());
		modalityController.setNewAdministrationService(newAdminService);
		assertEquals(newAdminService , modalityController.getNewAdministrationService());
		
	}
	
}
