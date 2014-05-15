package org.jmlim.sample.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Administrator
 * 
 */
public abstract class AbstractJpaDaoService {

	@PersistenceContext
	private EntityManager em;

	public EntityManager getEntityManager() {
		return this.em;
	}
}
