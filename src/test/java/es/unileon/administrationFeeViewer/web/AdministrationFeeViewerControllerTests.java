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

public class AdministrationFeeViewerControllerTests {

	private AdministrationFeeViewerController adminController;
	private NewAdministrationServiceImpl implementation;
	private InMemoryAccountDao accountDao;
	private Account account;
	
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
	
	@Test
	public void testSetAndGetNewAdministrationService(){
		
		NewAdministrationService newAdminService = new NewAdministrationServiceImpl();
		assertNull(adminController.getNewAdministrationService());
		adminController.setNewAdministrationService(newAdminService);
		assertEquals(newAdminService , adminController.getNewAdministrationService());
		
	}
	
	
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
