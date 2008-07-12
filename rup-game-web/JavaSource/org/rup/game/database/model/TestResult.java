package org.rup.game.database.model;

/**
 * 
 * @author KLM63827
 */
public class TestResult extends BaseDomainObject {

	private String username;
	
	private int score;
	
	private Subject topic;
	
	private Skill skill;
	
	/**
	 * @return Returns the score.
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * @param score The score to set.
	 */
	public void setScore(int score) {
		this.score = score;
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
	/**
	 * @return Returns the topic.
	 */
	public Subject getTopic() {
		return topic;
	}
	/**
	 * @param topic The topic to set.
	 */
	public void setTopic(Subject topic) {
		this.topic = topic;
	}
	/**
	 * @return Returns the username.
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username The username to set.
	 */
	public void setUsername(String username) {
		this.username = username;
	}
}
