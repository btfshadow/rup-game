package org.rup.game.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.rup.game.controller.bean.ViewBean;
import org.rup.game.database.dao.SubjectDao;
import org.rup.game.mock.utils.MockUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 
 * @author KLM63827
 */
public class SubjectController implements Controller {
	private static final Logger LOG = Logger.getLogger(SubjectController.class);
	
	private SubjectDao subjectDao;

	public SubjectController(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}
	
	/**
	 * 
	 */
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		LOG.info("Reading subjects from database.");
		
		List subjectList = subjectDao.list();
		LOG.info("Loaded " + subjectList.size() + " subjects.");
		
		final HashMap model = new HashMap();
		model.put("subjectList", subjectList);
		
		return new ModelAndView("chooseSubject", model);
	}

}
