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

@Controller
public class AdministrationFeeViewerController {

    protected final Log logger = LogFactory.getLog(getClass());
    
    @Autowired
    private NewAdministrationService newAdministrationService;

    @RequestMapping(value="/mainPage.htm")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("account", this.newAdministrationService.getAccount());

        return new ModelAndView("mainPage", "model", myModel);
    }

	public NewAdministrationService getNewAdministrationService() {
		return newAdministrationService;
	}

	public void setNewAdministrationService(
			NewAdministrationService newAdministrationService) {
		this.newAdministrationService = newAdministrationService;
	}
    
    
}
