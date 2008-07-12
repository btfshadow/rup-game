package org.rup.game.database.model;

/**
 * 
 * @author KLM63827
 */
public class Skill extends BaseDomainObject {
	
	private int level;

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
}
