package org.rup.game.database.dao;

import org.rup.game.database.model.BaseDomainObject;

/**
 * 
 *
 * @author klm63827
 */
public class Subject extends AbstractDaoSupport {
	
	private static String ENTITY_NAME = "Subject";
	
	/**
	 * @param persistedClass
	 */
	public Subject() {
		super(BaseDomainObject.class, ENTITY_NAME);
	}
}
