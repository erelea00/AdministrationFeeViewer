package es.unileon.administrationFeeViewer.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class AdministrationFeeViewerControllerTests {

	@Test (expected=NullPointerException.class)
	public void testHandleRequestView() throws Exception{		
        AdministrationFeeViewerController controller = new AdministrationFeeViewerController();
        ModelAndView modelAndView = controller.handleRequest(null, null);	
        System.out.println(modelAndView.getViewName());
        assertEquals("mainPage", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
    }

}
