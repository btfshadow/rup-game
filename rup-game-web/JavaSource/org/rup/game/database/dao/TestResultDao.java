package org.rup.game.database.dao;

import org.rup.game.database.model.TestResult;

/**
 * 
 *
 * @author klm63827
 */
public class TestResultDao extends AbstractDaoSupport {
	
	private static String ENTITY_NAME = "Result";
	
	/**
	 * @param persistedClass
	 */
	public TestResultDao() {
		super(TestResult.class, ENTITY_NAME);
	}
}
