package org.rup.game.controller;

import java.util.ArrayList;
import java.util.Date;
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
import org.rup.game.controller.bean.UserBean;
import org.rup.game.database.dao.SubjectDao;
import org.rup.game.database.model.Question;
import org.rup.game.database.model.Subject;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * 
 * @author KLM63827
 */
public class TestController extends SimpleFormController {
	private static final Logger LOG = Logger.getLogger(TestController.class);
	
	private SubjectDao subjectDao;
	
	private int testSize = 5;
	
	public TestController(SubjectDao baseDao) {
		super();
		this.subjectDao = baseDao;
	}
	
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		LOG.info("Creating a test for user " + EntryController.getUserFromSession(request));
		
		long subjectId = ServletRequestUtils.getRequiredLongParameter(request, "subjectId");
		long skillId = ServletRequestUtils.getRequiredLongParameter(request, "skillId");
		final Subject subject = (Subject) subjectDao.get(new Long(subjectId));
		
		if (subject == null) {
			LOG.error("Could not find a subject with id=" + subjectId);
			
			QuizBean quizBean = new QuizBean();
			quizBean.setQuestions(new ArrayList());
			return quizBean;
			
		} else {
			LOG.info("Loaded subject " + subject.getName()
					+ "with " + subject.getQuestions().size() + " questions.");

			// Pick a random set of questions to ask.
			
			final Set randomQuestions = getRandomQuestions(subject.getQuestions());
			
			// Transform the set of selected questions
			// into ordered list to be displayed on the screen.
			
			final List listOfRandomQuestions = new ArrayList();
			for (Iterator iter = randomQuestions.iterator(); iter.hasNext(); ) {
				Question q = (Question) iter.next();
				listOfRandomQuestions.add(new QuestionBean(q));
			}
			
			final QuizBean bean = new QuizBean();
			bean.setQuestions(listOfRandomQuestions);
			
			// Mark timestamp of the start of the test
			// TODO: Load skill from database instead of using hardcoded values
			EntryController.getUserFromSession(request).startQuiz(
					new Date().getTime(), subject.getName(), (skillId == 1) ? "Beginner" : "Advanced");
			return bean;
		}
	}

	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException e)
			throws Exception {
		
		final QuizBean filledQuiz = (QuizBean) command;
		final UserBean userBean = EntryController.getUserFromSession(request);
		final ResultBean result = new ResultBean();
		final long elapsedMilis = new Date().getTime() - userBean.getCurrentQuiz().getTsStarted();
		
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTimeInMillis(userBean.getCurrentQuiz().getTsStarted());
		LOG.debug("Test start time: " + c.getTime());
		LOG.debug("Current time:" + new java.util.Date());
		LOG.debug("Elapsed milis: " + elapsedMilis);
		
		result.setDurationTime(elapsedMilis);
		result.setSubjectName(userBean.getCurrentQuiz().getSubjectName());
		result.setSkillLevelName(userBean.getCurrentQuiz().getSkillLevelName());
		
		userBean.closeCurrentQuiz();
		
		LOG.debug("Assesing quiz for user " + userBean);
		calculateScore(result, filledQuiz);
		
		request.getSession().setAttribute("result", result);
		return new ModelAndView(new RedirectView("certificate.htm"));
	}

	/**
	 * @param filledQuiz
	 * @return
	 */
	private void  calculateScore(final ResultBean resultBean, final QuizBean filledQuiz) {
		
		int totalScore = 0;
		final int questionNumber = filledQuiz.getQuestions().size();
		
		for (int i = 0; i < filledQuiz.getQuestions().size(); i++) {
			final QuestionBean question = (QuestionBean) filledQuiz.getQuestions().get(i);
			LOG.debug("  " + (i + 1) +  ". " +  question.getText());
			
			boolean questionCorrect = true;

			for (int ia = 0; ia < question.getAnswers().size(); ia++) {
				final AnswerBean answer = (AnswerBean) question.getAnswers().get(ia);
				LOG.debug("    Answer: " + answer);
				LOG.debug("      User: " + answer.getUserinput());

				final boolean answerCorrect = "true".equals(answer.getUserinput()) == answer.isCorrect();
				LOG.debug("      Mark: " + (answerCorrect ? "correct" : "INCORRECT"));
				if (!answerCorrect) {
					questionCorrect = false;
				}
			}
			
			final int questionScore = (questionCorrect) ? 1 : 0;
			LOG.debug("  Question score: " + questionScore);
			totalScore += questionScore;
		}
		
		LOG.debug("Total score: " + totalScore);
		LOG.debug("Nr of questions: " + questionNumber);
		int result = 0;
		
		if (totalScore == questionNumber) {
			result = 5;
		} else {
			result = (int) Math.round((((double)totalScore) / ((double)questionNumber)) * 5);
			if (result < 1)
				result = 1;
			if (result > 4)
				result = 4;
		}
		
		LOG.debug("Result: " + result);
		resultBean.setResult(result);
	}

	/**
	 * @param questions
	 * @return
	 */
	private Set getRandomQuestions(final Set questions) {

		Random randomGenerator = new Random();
		    
		final List listOfQuestions = new ArrayList();
		final int numberOfQuestions = questions.size();

		while(listOfQuestions.size() < testSize) {
			Integer choice = new Integer(randomGenerator.nextInt(numberOfQuestions));
			if(!listOfQuestions.contains(choice)) {
				listOfQuestions.add(choice);
			}
		}
		
		final Question[] allQuestions = (Question[]) questions.toArray(new Question[questions.size()]);
		final Set randomQuestions = new HashSet();
		for (Iterator iter = listOfQuestions.iterator(); iter.hasNext();) {
			final Integer i = (Integer) iter.next();
			randomQuestions.add(allQuestions[i.intValue()]);
		}
		
		return randomQuestions;
	}
	
	public void setTestSize(int testSize) {
		this.testSize = testSize;
	}
}
