package org.rup.game.database.dao;

import org.rup.game.database.model.Answer;

/**
 * 
 *
 * @author klm63827
 */
public class AnswerDao extends AbstractDaoSupport {
	
	private static String ENTITY_NAME = "Answer";
	
	/**
	 * @param persistedClass
	 */
	public AnswerDao() {
		super(Answer.class, ENTITY_NAME);
	}
}
