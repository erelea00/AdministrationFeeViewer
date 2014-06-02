package es.unileon.administrationFeeViewer.web;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.administrationFeeViewer.domain.Account;
import es.unileon.administrationFeeViewer.repository.InMemoryAccountDao;
import es.unileon.administrationFeeViewer.services.NewAdministrationService;
import es.unileon.administrationFeeViewer.services.NewAdministrationServiceImpl;

/**
 * Class which tests the methods contained inside the AdministrationFeeViewerController class
 * @author EmanuelIosif
 *
 */
public class AdministrationFeeViewerControllerTests {
	
	/**
	 * Administration controller used to invoke the methods to be tested
	 */
	private AdministrationFeeViewerController adminController;
	
	/**
	 * New service implementation used to set a new administration fee to an account
	 */
	private NewAdministrationServiceImpl implementation;
	
	/**
	 * Account Data Access Object which retrieves an account
	 */
	private InMemoryAccountDao accountDao;
	
	/**
	 * Account to be used by the Account DAO
	 */
	private Account account;
	
	/**
	 * Initializes all the fields and makes the necessary assignments
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception{
		
		adminController = new AdministrationFeeViewerController();
		
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
		
		implementation = new NewAdministrationServiceImpl();
		implementation.setAccountDao(accountDao);
	}
	
	/**
	 * Tests setter and getter for the newAdministrationService field
	 */
	@Test
	public void testSetAndGetNewAdministrationService(){
		
		NewAdministrationService newAdminService = new NewAdministrationServiceImpl();
		assertNull(adminController.getNewAdministrationService());
		adminController.setNewAdministrationService(newAdminService);
		assertEquals(newAdminService , adminController.getNewAdministrationService());
		
	}
	
	
	/**
	 * Tests whether the model and view are returned correctly after a new request is received.
	 * Also tests that the account is successfully retrieved from the model
	 * @throws Exception
	 */
	@Test 
	public void testHandleRequestView() throws Exception{	
		
        adminController.setNewAdministrationService(implementation);
        
        ModelAndView modelAndView = adminController.handleRequest(null, null);	
        
        assertEquals("mainPage", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        
        @SuppressWarnings("unchecked")
		Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
        Account accountValue = (Account) modelMap.get("account");
        
        assertNotNull(accountValue);
        
    }
	
}
