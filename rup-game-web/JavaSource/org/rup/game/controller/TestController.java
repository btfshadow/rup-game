package org.rup.game.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.rup.game.controller.bean.AnswerBean;
import org.rup.game.controller.bean.QuestionBean;
import org.rup.game.controller.bean.QuizBean;
import org.rup.game.controller.bean.ResultBean;
import org.rup.game.database.dao.SubjectDao;
import org.rup.game.database.model.Answer;
import org.rup.game.database.model.Question;
import org.rup.game.database.model.Subject;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * 
 * @author KLM63827
 */
public class TestController extends SimpleFormController {
	private static final Logger LOG = Logger.getLogger(TestController.class);
	
	private SubjectDao subjectDao;
	
	public TestController(SubjectDao baseDao) {
		super();
		this.subjectDao = baseDao;
		setFormView("test");
		setCommandName("testBean");
	}

	protected ModelAndView onSubmit(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		LOG.info("Evaluating the test.");
		
		final QuizBean result = (QuizBean) arg2;
		
		ResultBean resultBean = calculateResult(result); 
		final HashMap model = new HashMap();
		model.put("resultBean", resultBean);
		setSuccessView("testResult");
		ModelAndView mav = new ModelAndView("testResult", model);
		return mav;
	}

	/**
	 * @param result
	 * @return
	 */
	private ResultBean calculateResult(QuizBean result) {
		
		int score = 0;
		ResultBean resultBean = new ResultBean();
		Iterator it = result.getQuestions().iterator();
		while (it.hasNext()) {
			QuestionBean question = (QuestionBean)it.next();
			System.out.println("Question: " +  question.getText());
			Iterator iteratorAnswers = question.getAnswers().iterator();
			while (iteratorAnswers.hasNext()) {
				AnswerBean answer = (AnswerBean)iteratorAnswers.next();
				System.out.println("  " + answer.getText() + ": " + answer.getUserinput());
				if("true".equals(answer.getUserinput()) && answer.isCorrect())
				{
					score++;
					break;					
				}
			}
		}
		resultBean.setResult(score/2);
		return resultBean;
	}

	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		LOG.info("Creating a test.");
		long subjectId = ServletRequestUtils.getRequiredLongParameter(request, "subjectId");
		
		Subject subject = (Subject) subjectDao.get(new Long(subjectId));
		if (subject == null) {
			LOG.error("Could not find subject with id=" + subjectId);
			
			QuizBean quizBean = new QuizBean();
			quizBean.setQuestions(new ArrayList());
			return quizBean;
			
		} else {
			LOG.info("Loaded subject " + subject.getName() + "with " + subject.getQuestions().size()
					+ " questions.");

			Set randomQuestions = getRandomQuestions(subject.getQuestions());
			
			List listOfRandomQuestions = new ArrayList();
			Iterator itRandom = randomQuestions.iterator();
			while(itRandom.hasNext()) {
				Question q = (Question)itRandom.next();
				QuestionBean newQuestion = new QuestionBean();
				newQuestion.setText(q.getDescription());
				List listAnswers = getAnswers(q.getAnswers());
				newQuestion.setAnswers(listAnswers);
				listOfRandomQuestions.add(newQuestion);
			}
			
			final QuizBean bean = new QuizBean();
			bean.setQuestions(listOfRandomQuestions);
			
			return bean;
		}
	}

	/**
	 * @param set
	 * @return
	 */
	private List getAnswers(Set answers) {
		
		List newAnswers = new ArrayList();
		Iterator itAnswers = answers.iterator();
		while(itAnswers.hasNext()) {
			AnswerBean newAnswer = new AnswerBean();
			Answer answer = (Answer)itAnswers.next();
			newAnswer.setCorrect(answer.isCorrect());
			newAnswer.setText(answer.getText());
			newAnswers.add(newAnswer);
		}
		
		return newAnswers;
	}

	/**
	 * @param questions
	 * @return
	 */
	private Set getRandomQuestions(Set questions) {

		Random randomGenerator = new Random();
		    
		List listOfQuestions = new ArrayList();
		int numberQuestions = questions.size();
		while(listOfQuestions.size() < 2)
		{
			Integer choice = new Integer(randomGenerator.nextInt(numberQuestions));
			if(!listOfQuestions.contains(choice)) {
				listOfQuestions.add(choice);
			}
		}
		
		Question[] arrayOfQuestions = (Question[]) questions.toArray(new Question[questions.size()]);
		Set randomQuestions = new HashSet();
		Iterator it = listOfQuestions.iterator();
		while (it.hasNext()) {
			Integer i = (Integer)it.next();
			randomQuestions.add(arrayOfQuestions[i.intValue()]);
		}
		
		return randomQuestions;
	}
}
