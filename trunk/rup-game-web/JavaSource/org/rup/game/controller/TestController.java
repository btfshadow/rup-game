package org.rup.game.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.rup.game.controller.bean.ViewBean;
import org.rup.game.database.dao.BaseDao;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * 
 * @author KLM63827
 */
public class TestController extends SimpleFormController {
	private static final Logger LOG = Logger.getLogger(TestController.class);
	
	private BaseDao baseDao;
	
	public TestController(BaseDao baseDao) {
		super();
		this.baseDao = baseDao;
		setFormView("test");
		setCommandName("testBean");
	}

	protected ModelAndView onSubmit(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		LOG.info("Evaluating the test.");
		
		setSuccessView("testResult");
		ModelAndView mav = new ModelAndView("testResult");
		return mav;
	}

	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		LOG.info("Creating a test.");
		
		final ViewBean bean = new ViewBean();
		bean.setObjectsCount(baseDao.list().size());
		
		return bean;
	}
}
