package org.rup.game.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.rup.game.controller.bean.ViewBean;
import org.rup.game.database.dao.BaseDao;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * 
 * @author KLM63827
 */
public class BaseController extends SimpleFormController {
	private static final Logger LOG = Logger.getLogger(BaseController.class);
	
	private BaseDao baseDao;
	
	public BaseController(BaseDao baseDao) {
		super();
		this.baseDao = baseDao;
		setFormView("welcome");
		setCommandName("viewBean");
	}

	protected ModelAndView onSubmit(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		
		return super.onSubmit(arg0, arg1, arg2, arg3);
	}

	protected Object formBackingObject(HttpServletRequest arg0)
			throws Exception {
		LOG.info("Reading domain objects from database.");
		
		final ViewBean bean = new ViewBean();
		bean.setObjectsCount(baseDao.list().size());
		
		return bean;
	}
}
