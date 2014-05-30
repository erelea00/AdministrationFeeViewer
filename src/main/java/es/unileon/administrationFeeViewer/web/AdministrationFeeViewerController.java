package es.unileon.administrationFeeViewer.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.administrationFeeViewer.services.NewAdministrationService;

/**
 * Administration fee front controller which handles all requests
 * @author EmanuelIosif
 *
 */
@Controller
public class AdministrationFeeViewerController {
	
	/**
	 * Logger
	 */
    protected final Log logger = LogFactory.getLog(getClass());
    
    /**
     * Autowired administration fee field
     */
    @Autowired
    private NewAdministrationService newAdministrationService;
    
    /**
     * Handles all incoming requests
     * @param request Request for a page
     * @param response Response for the request
     * @return A model and view
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value="/mainPage.htm")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("account", this.newAdministrationService.getAccount());

        return new ModelAndView("mainPage", "model", myModel);
    }
    
    /**
     * Getter for the newAdministrationService attribute
     * @return A new Administration Service
     */
	public NewAdministrationService getNewAdministrationService() {
		return newAdministrationService;
	}

	/**
	 * Setter for the newAdministration attribute 
	 * @param newAdministrationService A new Administration Service
	 */
	public void setNewAdministrationService(
			NewAdministrationService newAdministrationService) {
		this.newAdministrationService = newAdministrationService;
	}
    
    
}
