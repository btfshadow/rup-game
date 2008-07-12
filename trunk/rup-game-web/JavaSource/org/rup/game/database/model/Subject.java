package org.rup.game.database.model;

import java.util.List;

/**
 * 
 * @author KLM63827
 */
public class Subject extends BaseDomainObject {

	private List questions;
	private String name;
	
	
	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
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
