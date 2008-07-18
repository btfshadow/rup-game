package org.rup.game.controller.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.rup.game.database.model.Answer;
import org.rup.game.database.model.Question;

/**
 * @author KLM63827
 */
public class QuestionBean {
	
	private String text;

	private List answers;
	
	/**
	 * Creates empty {@link QuestionBean}.
	 *
	 */
	public QuestionBean() {
		super();
	}
	
	/**
	 * Creates a copy of {@link Question}.
	 * 
	 * @param question
	 */
	public QuestionBean(final Question question) {
		super();
		setText(question.getDescription());
		setAnswers(new ArrayList());
		
		for (Iterator iter = question.getAnswers().iterator(); iter.hasNext();) {
			final Answer answer = (Answer) iter.next();
			getAnswers().add(new AnswerBean(answer));
		}
	}
	
	/**
	 * @return Returns the answers.
	 */
	public List getAnswers() {
		return answers;
	}
	/**
	 * @param answers The answers to set.
	 */
	public void setAnswers(List answers) {
		this.answers = answers;
	}
	/**
	 * @return Returns the text.
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text The text to set.
	 */
	public void setText(String text) {
		this.text = text;
	}
}
