package org.rup.game.controller.bean;

import java.util.List;

/**
 * 
 * @author KLM63827
 */
public class QuizBean extends ViewBean {

	private List questions;
	
	/**
	 * @return Returns the questions.
	 */
	public List getQuestions() {
		return questions;
	}

	/**
	 * @param questions The questions to set.
	 */
	public void setQuestions(List questions) {
		this.questions = questions;
	}
}
