package org.rup.game.controller.bean;

import java.util.Set;

/**
 * 
 * @author KLM63827
 */
public class QuizBean extends ViewBean {

	private Set questions;
	
	/**
	 * @return Returns the questions.
	 */
	public Set getQuestions() {
		return questions;
	}

	/**
	 * @param questions The questions to set.
	 */
	public void setQuestions(Set questions) {
		this.questions = questions;
	}
}
