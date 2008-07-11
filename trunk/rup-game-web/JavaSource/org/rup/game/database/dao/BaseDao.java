package org.rup.game.database.dao;

import org.rup.game.database.model.BaseDomainObject;

/**
 * 
 *
 * @author klm63827
 */
public class BaseDao extends AbstractDaoSupport {
	
	private static String ENTITY_NAME = "BaseDomainObject";
	
	/**
	 * @param persistedClass
	 */
	public BaseDao() {
		super(BaseDomainObject.class, ENTITY_NAME);
	}
}
