/*
 * Created on Jul 12, 2008
 */
package org.rup.game.mock.utils;

import java.util.ArrayList;
import java.util.List;

import org.rup.game.database.model.Answer;
import org.rup.game.database.model.Question;
import org.rup.game.database.model.Subject;



/**
 * @author KLM67267
 */
public class MockUtils {

	public List getSubject()
	{
		List subjects = new ArrayList();
		Subject subjectOne = new Subject();
		List questions = getQuestions();
		subjectOne.setQuestions(questions);
		subjectOne.setName("Sports");
		return subjects;		
	}

	/**
	 * @return
	 */
	private List getQuestions() {
		List questions = new ArrayList();
		Question q = new Question();
		q.setDescription("Who is best footballer in thw world?");
		List answers = getAnswers();
		q.setAnswers(answers);
		return questions;
	}

	/**
	 * @return
	 */
	private List getAnswers() {
		List answers = new ArrayList();
		Answer answer = new Answer();
		answer.setCorrect(true);
		answer.setText("Eusebio");
		
		Answer answerToo = new Answer();
		answerToo.setCorrect(true);
		answerToo.setText("What is football?");
		
		answers.add(answer);
		answers.add(answerToo);
		return answers;
	}
}
