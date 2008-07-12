package org.rup.game.database.dao;

import org.rup.game.database.model.Subject;

/**
 * 
 *
 * @author klm63827
 */
public class SubjectDao extends AbstractDaoSupport {
	
	private static String ENTITY_NAME = "Subject";
	
	/**
	 * @param persistedClass
	 */
	public SubjectDao() {
		super(Subject.class, ENTITY_NAME);
	}
}
