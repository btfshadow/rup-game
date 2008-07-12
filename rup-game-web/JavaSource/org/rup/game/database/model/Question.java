package org.rup.game.database.model;

import java.util.List;

/**
 * 
 * @author KLM63827
 */
public class Question  extends BaseDomainObject {

	private String text;
	
	private Skill skill;
	
	private List answers;
	
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
	
	/**
	 * @return Returns the skill.
	 */
	public Skill getSkill() {
		return skill;
	}
	
	/**
	 * @param skill The skill to set.
	 */
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
}
