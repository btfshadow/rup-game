package org.rup.game.database.dao;

import org.rup.game.database.model.BaseDomainObject;

/**
 * 
 *
 * @author klm63827
 */
public class SkillLevelDao extends AbstractDaoSupport {
	
	private static String ENTITY_NAME = "SkillLevel";
	
	/**
	 * @param persistedClass
	 */
	public SkillLevelDao() {
		super(BaseDomainObject.class, ENTITY_NAME);
	}
}
