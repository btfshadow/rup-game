package org.rup.game.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.rup.game.controller.bean.UserBean;
import org.rup.game.database.dao.SubjectDao;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * 
 * @author KLM63827
 */
public class EntryController extends SimpleFormController {
	private static final Logger LOG = Logger.getLogger(EntryController.class);
	
	private SubjectDao subjectDao;
	
	public EntryController(SubjectDao baseDao) {
		super();
		this.subjectDao = baseDao;
	}

	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		UserBean user = (UserBean) arg2;
		
		LOG.info("Creating session for user " + user);
		request.getSession().setAttribute("user", user);

		return new ModelAndView(new RedirectView("subjects.htm"));
	}
	
	public static UserBean getUserFromSession(HttpServletRequest request) {
		final UserBean user = (UserBean) request.getSession().getAttribute("user");
		if (user == null) {
			LOG.warn("Session expired.");
			throw new SessionExpiredException();
		}
		return user;
	}
}
