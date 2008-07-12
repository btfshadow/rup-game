package org.rup.game.database.dao;

import org.rup.game.database.model.BaseDomainObject;

/**
 * 
 *
 * @author klm63827
 */
public class QuestionDao extends AbstractDaoSupport {
	
	private static String ENTITY_NAME = "Question";
	
	/**
	 * @param persistedClass
	 */
	public QuestionDao() {
		super(BaseDomainObject.class, ENTITY_NAME);
	}
}
