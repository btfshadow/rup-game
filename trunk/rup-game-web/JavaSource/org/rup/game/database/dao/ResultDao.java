package org.rup.game.database.dao;

import org.rup.game.database.model.BaseDomainObject;

/**
 * 
 *
 * @author klm63827
 */
public class ResultDao extends AbstractDaoSupport {
	
	private static String ENTITY_NAME = "Result";
	
	/**
	 * @param persistedClass
	 */
	public ResultDao() {
		super(BaseDomainObject.class, ENTITY_NAME);
	}
}
