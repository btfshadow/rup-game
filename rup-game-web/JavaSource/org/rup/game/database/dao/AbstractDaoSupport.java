package org.rup.game.database.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 
 *
 * @author klm63827
 */
public abstract class AbstractDaoSupport extends HibernateDaoSupport {
	private static final Logger LOG = Logger.getLogger(AbstractDaoSupport.class);

	private Class persistedClass;
	private String tableName;
	
	public AbstractDaoSupport(final Class persistedClass, final String tableName) {
		LOG.debug("Creating DAO object for " + tableName);
		
		this.persistedClass = persistedClass;
		this.tableName = tableName;
	}

	/* (non-Javadoc)
	 * @see com.klm.mmb.database.dao.IDao#list()
	 */
	public List list() {
		return getHibernateTemplate().find("FROM " + tableName);
	}

	/* (non-Javadoc)
	 * @see com.klm.mmb.database.dao.IDao#get(java.lang.String)
	 */
	public Object get(Long objectId) {
		
		return (Object) getHibernateTemplate().get(persistedClass, objectId);
	}

	/* (non-Javadoc)
	 * @see com.klm.mmb.database.dao.IDao#update(com.klm.mmb.database.model.AbstractDomainObject)
	 */
	public void update(Object object) {
		if (object != null)
			getHibernateTemplate().saveOrUpdate(object);
	}

	/* (non-Javadoc)
	 * @see com.klm.mmb.database.dao.IDao#delete(java.lang.String)
	 */
	public void delete(Long objectId) {

		Object toDelete = get(objectId);
		
        if (toDelete != null) {

            getHibernateTemplate().delete(toDelete);
        }
	}

	protected Object assertSingleAndReturnFirst(List result) {
		
		if (result.size() == 0) {
			
			LOG.warn("Query expected to return 1 row from '" + tableName + "' but 0 were found. Returning null.");
			return null;
			
		} else if (result.size() > 1) {
			
			LOG.warn("Query expected to return 1 row from '" + tableName + "' but " + result.size() + " were found" +
					"(cosistency might be violated). Returning first row.");
		}
		
		return result.get(0);
	}
}
