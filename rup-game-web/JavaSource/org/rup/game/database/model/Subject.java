package org.rup.game.database.model;

import java.util.Set;

/**
 * 
 * @author KLM63827
 */
public class Subject extends BaseDomainObject {

	private Set questions;
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
