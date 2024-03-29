package org.rup.game.database.model;


/**
 * 
 * @author KLM63827
 */
public class Answer  extends BaseDomainObject {
	
	private String text;
	
	private boolean correct;
	
	private String userAnswer;

	/**
	 * @return Returns the correct.
	 */
	public boolean isCorrect() {
		return correct;
	}
	
	/**
	 * @param correct The correct to set.
	 */
	public void setCorrect(boolean correct) {
		this.correct = correct;
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
	 * @return Returns the userAnswer.
	 */
	public String setUserAnswer() {
		return userAnswer;
	}
	/**
	 * @param userAnswer The userAnswer to set.
	 */
	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}
}
