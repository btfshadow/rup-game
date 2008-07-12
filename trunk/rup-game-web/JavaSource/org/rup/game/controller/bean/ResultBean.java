/*
 * Created on Jul 12, 2008
 *
 */
package org.rup.game.controller.bean;

/**
 * @author KLM67267
 *
 */
public class ResultBean extends ViewBean {

	private int result;
	private String Subject;
	private String skillLevel;
	
	/**
	 * @return Returns the result.
	 */
	public int getResult() {
		return result;
	}
	/**
	 * @param result The result to set.
	 */
	public void setResult(int result) {
		this.result = result;
	}
	/**
	 * @return Returns the skillLevel.
	 */
	public String getSkillLevel() {
		return skillLevel;
	}
	/**
	 * @param skillLevel The skillLevel to set.
	 */
	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}
	
	/**
	 * @return Returns the subject.
	 */
	public String getSubject() {
		return Subject;
	}
	/**
	 * @param subject The subject to set.
	 */
	public void setSubject(String subject) {
		Subject = subject;
	}
}
