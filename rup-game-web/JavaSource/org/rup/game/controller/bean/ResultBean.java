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
	private String subjectName;
	private String skillLevelName;
	private String durationTime;
	
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
	public String getSkillLevelName() {
		return skillLevelName;
	}
	/**
	 * @param skillLevel The skillLevel to set.
	 */
	public void setSkillLevelName(String skillLevel) {
		this.skillLevelName = skillLevel;
	}
	
	/**
	 * @return Returns the subject.
	 */
	public String getSubjectName() {
		return subjectName;
	}
	/**
	 * @param subject The subject to set.
	 */
	public void setSubjectName(String subject) {
		subjectName = subject;
	}
	/**
	 * @return Returns the durationTime.
	 */
	public String getDurationTime() {
		return durationTime;
	}
	/**
	 * @param durationTime The durationTime to set.
	 */
	public void setDurationTime(String durationTime) {
		this.durationTime = durationTime;
	}
	/**
	 * 
	 * @param totalMiliseconds
	 */
	public void setDurationTime(long totalMiliseconds) {
		
		final int hours = (int) Math.floor(totalMiliseconds / (60 * 60 * 1000));
		final int afterHours = (int) (totalMiliseconds - 60 * 60 * 1000 * hours);
		
		final int minutes = (int) Math.floor(afterHours / (60 * 1000));
		final int afterMinutes = afterHours - 60 * 100 * minutes;
		
		final int seconds = (int) Math.floor(afterMinutes / 1000);
		final int miliseconds = (int) (totalMiliseconds % 1000);
		
		setDurationTime(hours + ":" + minutes + ":" + seconds + "." + miliseconds);
	}
}
