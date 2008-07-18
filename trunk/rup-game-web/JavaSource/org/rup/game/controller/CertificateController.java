package org.rup.game.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.rup.game.controller.bean.ResultBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

/**
 * 
 * @author KLM63827
 */
public class CertificateController implements Controller {
	private static final Logger LOG = Logger.getLogger(CertificateController.class);

	/**
	 * 
	 */
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// Get certificate from session
		final ResultBean result = (ResultBean) request.getSession().getAttribute("result");
		if (result == null) {
			LOG.error("Could not find a certificate in session.");
			return new ModelAndView(new RedirectView("entry.htm"));
		}
		
		final HashMap model = new HashMap();
		model.put("resultBean", result);
		
		final ModelAndView mav = new ModelAndView("certificate", model);
		return mav;
	}
}
