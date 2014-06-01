package es.unileon.administrationFeeViewer.web;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.administrationFeeViewer.services.NewAdministrationService;
import es.unileon.administrationFeeViewer.services.NewAdministrationServiceImpl;

public class SetModalityControllerTests {

	private SetModalityController modalityController;
	
	@Before
	public void setUp() throws Exception{
		
		modalityController = new SetModalityController();
		
	}
	
	@Test
	public void testSetAndGetNewAdministrationService(){
		
		NewAdministrationService newAdminService = new NewAdministrationServiceImpl();
		assertNull(modalityController.getNewAdministrationService());
		modalityController.setNewAdministrationService(newAdminService);
		assertEquals(newAdminService , modalityController.getNewAdministrationService());
		
	}
	
}
