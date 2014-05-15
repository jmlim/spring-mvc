package org.jmlim.sample.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.jmlim.sample.model.User;
import org.jmlim.sample.service.AbstractJpaDaoService;
import org.jmlim.sample.service.UserManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 * 
 */
@Service("userManager")
@Transactional
public class UserManagerImpl extends AbstractJpaDaoService implements
		UserManager {

	/**
	 * @see org.jmlim.sample.service.UserManager#getUser(java.lang.String)
	 */
	@Transactional(readOnly = true)
	public User getUser(String userId) {
		List<User> results = getEntityManager()
				.createNamedQuery("org.jmlim.sample.model.User@getUser(uId)",
						User.class).setParameter("uId", userId).getResultList();

		if (results != null && results.size() > 0) {
			return results.get(0);
		}
		return null;
	}

	/**
	 * @see org.jmlim.sample.service.UserManager#createUser(org.jmlim.sample.model.User)
	 */
	public void createUser(User user) {
		user.setCreatedDate(new Date());
		List<String> userRoles = user.getRoles();
		if (userRoles == null || userRoles.isEmpty()) {
			userRoles = new ArrayList<String>();
			userRoles.add("ROLE_USER");
		}
		user.setRoles(userRoles);
		getEntityManager().persist(user);
	}

	/**
	 * @see org.jmlim.sample.service.UserManager#updateUser(org.jmlim.sample.model.User)
	 */
	public void updateUser(User user) {
		user.setModifiedDate(new Date());
		getEntityManager().merge(user);
	}

	/**
	 * @see org.jmlim.sample.service.UserManager#deleteUser(org.jmlim.sample.model.User)
	 */
	public void deleteUser(User user) {
		EntityManager em = getEntityManager();
		getEntityManager().remove(em.contains(user) ? user : em.merge(user));
	}

	/**
	 * @see org.jmlim.sample.service.UserManager#getUsers()
	 */
	@Transactional(readOnly = true)
	public List<User> getUsers() {
		List<User> results = getEntityManager().createNamedQuery(
				"org.jmlim.sample.model.User@getUser()", User.class)
				.getResultList();
		if (results != null && results.size() > 0) {
			return results;
		}

		return null;
	}
}
