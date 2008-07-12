package org.rup.game.controller.bean;

import java.util.List;

/**
 * @author KLM63827
 */
public class QuestionBean {
	
	private String text;

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
}
