package org.rup.game.database.dao;

import org.rup.game.database.model.BaseDomainObject;

/**
 * 
 *
 * @author klm63827
 */
public class TopicDao extends AbstractDaoSupport {
	
	private static String ENTITY_NAME = "Topic";
	
	/**
	 * @param persistedClass
	 */
	public TopicDao() {
		super(BaseDomainObject.class, ENTITY_NAME);
	}
}
