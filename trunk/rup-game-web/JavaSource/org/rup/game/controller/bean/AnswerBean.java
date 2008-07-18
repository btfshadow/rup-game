/*
 * Created on Jul 12, 2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.rup.game.controller.bean;

import org.rup.game.database.model.Answer;

/**
 * @author KLM63827
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AnswerBean {

	private String text;
	
	private boolean correct;
	
	private String userinput;
	
	public AnswerBean() {
		super();
	}
	
	public AnswerBean(final Answer answer) {
		setText(answer.getText());
		setCorrect(answer.isCorrect());
	}
	
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
	 * @return Returns the userinput.
	 */
	public String getUserinput() {
		return userinput;
	}
	/**
	 * @param userinput The userinput to set.
	 */
	public void setUserinput(String userinput) {
		this.userinput = userinput;
	}
	
	public String toString() {
		return getText() + " [" + isCorrect() + "]";
	}
}
