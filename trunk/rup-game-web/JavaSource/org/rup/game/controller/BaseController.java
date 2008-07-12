package org.rup.game.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.rup.game.controller.bean.ViewBean;
import org.rup.game.database.dao.SubjectDao;
import org.rup.game.database.model.Subject;
import org.rup.game.mock.utils.MockUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * 
 * @author KLM63827
 */
public class BaseController extends SimpleFormController {
	private static final Logger LOG = Logger.getLogger(BaseController.class);
	
	private SubjectDao subjectDao;
	
	public BaseController(SubjectDao baseDao) {
		super();
		this.subjectDao = baseDao;
		setFormView("welcome");
		setCommandName("viewBean");
		setSuccessView("chooseSubject");
		
		if(MockUtils.called == false)
		{
			subjectDao.update(MockUtils.getSubject());
			MockUtils.called = true;
		}
	}

	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		LOG.info("Authenticating the user.");
		
		return super.onSubmit(request, arg1, arg2, arg3);
	}

	protected Object formBackingObject(HttpServletRequest arg0)
			throws Exception {
		LOG.info("Reading subjects from database.");
		
		List subjectList = subjectDao.list();
		LOG.info("Loaded " + subjectList.size() + " subjects.");
		
		Subject subject = new Subject();
		subject.setId(34);
		subject.setName("Mock");
		subjectList.add(subject);
		
		final ViewBean bean = new ViewBean();
		bean.setSubjectList(subjectList);
		return bean;
	}
}