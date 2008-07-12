package org.rup.game.database.model;

import java.util.List;

/**
 * 
 * @author KLM63827
 */
public class Question  extends BaseDomainObject {

	private String description;
	
	private List answers;
	
	private SkillLevel skillLevel;
	
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
	 * @return Returns the description.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description The description to set.
	 */
	public void setDescription(String text) {
		this.description = text;
	}
	
	/**
	 * @return Returns the skillLevel.
	 */
	public SkillLevel getSkillLevel() {
		return skillLevel;
	}
	/**
	 * @param skillLevel The skillLevel to set.
	 */
	public void setSkillLevel(SkillLevel skillLevel) {
		this.skillLevel = skillLevel;
	}
}
