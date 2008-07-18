package org.rup.game.database.model;

/**
 * 
 * @author KLM63827
 */
public class SkillLevel extends BaseDomainObject {
	
	private int level;
	
	private String name;

	public SkillLevel() {
		super();
	}
	
	public SkillLevel(int level, String name) {
		this.level = level;
		this.name = name;
	}
	
	/**
	 * @return Returns the level.
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level The level to set.
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	
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
}
