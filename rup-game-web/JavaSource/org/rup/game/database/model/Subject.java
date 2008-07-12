package org.rup.game.database.model;

import java.util.List;

/**
 * 
 * @author KLM63827
 */
public class Subject extends BaseDomainObject {

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
