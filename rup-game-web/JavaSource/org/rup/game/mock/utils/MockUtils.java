/*
 * Created on Jul 12, 2008
 */
package org.rup.game.mock.utils;

import java.util.HashSet;
import java.util.Set;

import org.rup.game.database.model.Answer;
import org.rup.game.database.model.Question;
import org.rup.game.database.model.Subject;



/**
 * @author KLM67267
 */
public class MockUtils {

	private static boolean called = false;
	
	public static Subject getSubject()
	{
		if (!called) {
			System.out.println("INSERT !!!!!!!!!!!!!!!!!!!!!!!!!!!");
			Set subjects = new HashSet();
			Subject subjectOne = new Subject();
			Set questions = getQuestions();
			subjectOne.setQuestions(questions);
			subjectOne.setName("Sports");
			subjects.add(subjectOne);
			
			called = true;
			return subjectOne;
		} else {
			
			return null;
		}
	}

	/**
	 * @return
	 */
	private static Set getQuestions() {
		Set questions = new HashSet();
		Question q = new Question();
		q.setDescription("Who is best footballer in thw world?");
		Set answers = getAnswers();
		q.setAnswers(answers);
		return questions;
	}

	/**
	 * @return
	 */
	private static Set getAnswers() {
		Set answers = new HashSet();
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
