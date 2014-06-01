package es.unileon.administrationFeeViewer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.unileon.administrationFeeViewer.services.NewAdministrationFee;
import es.unileon.administrationFeeViewer.services.NewAdministrationService;

/**
 * Controller which handles the get and post requests of the setModality view
 * @author EmanuelIosif
 *
 */
@Controller
@RequestMapping(value="/setModality.htm")
public class SetModalityController {

	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    /**
     * Autowired administration service field
     */
    @Autowired
    private NewAdministrationService newAdministrationService;
    
    /**
     * Method which handles the post method requests
     * @param newAdministrationFee A new administration fee for the account
     * @param result Holds the errors (if any) encountered
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid NewAdministrationFee newAdministrationFee, BindingResult result)
    {
        if (result.hasErrors()) {
        	logger.info("Error en el campo.");
            return "setModality";
        }      
        
        newAdministrationService.setNewAdminFee(newAdministrationFee);
        logger.info("New administration fee set.");

        return "redirect:/mainPage.htm";
    }
    
    /**
     * Method which handles the get method requests
     * @param request Request of get method
     * @return A new administration fee for the account
     * @throws ServletException
     */
    @RequestMapping(method = RequestMethod.GET)
    protected NewAdministrationFee formBackingObject(HttpServletRequest request) throws ServletException {
    	
        NewAdministrationFee newAdministrationFee = new NewAdministrationFee();
        
        return newAdministrationFee;
    }

    /**
     * Getter for the newAdministrationService attribute
     * @return A new Administration Service
     */
	public NewAdministrationService getNewAdministrationService() {
		return newAdministrationService;
	}

	/**
	 * Setter for the newAdministrationService attribute 
	 * @param newAdministrationService A new Administration Service
	 */
	public void setNewAdministrationService(
			NewAdministrationService newAdministrationService) {
		this.newAdministrationService = newAdministrationService;
	}
	
	
}
