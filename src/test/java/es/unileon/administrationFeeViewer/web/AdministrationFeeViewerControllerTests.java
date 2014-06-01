package es.unileon.administrationFeeViewer.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class AdministrationFeeViewerControllerTests {

	@Test 
	public void testHandleRequestView() throws Exception{		
        AdministrationFeeViewerController controller = new AdministrationFeeViewerController();
        ModelAndView modelAndView = controller.handleRequest(null, null);	
        assertEquals("mainPage", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
    }
	
}
