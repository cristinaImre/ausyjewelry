package ro.ausy.jewelry.server.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ro.ausy.jewelry.commons.dto.UserRoleDTO;
import ro.ausy.jewelry.server.dao.UserRoleDao;
import ro.ausy.jewelry.server.entity.UserRole;
import ro.ausy.jewelry.server.utils.HibernateUtils;

/**
 * This class implements the user methods that the client will be able to call through <code>UserManager</code> object.
 * 
 * @author cimre
 *
 */
@Repository
@Transactional
public class UserRoleDaoImpl implements UserRoleDao {
	
	/**
	 * This is the Hibernate local session that allows you to connect to the database.
	 */
	private SessionFactory sessionFactory;
	
	/**
	 * The logging object.
	 */
	private static final Logger LOGGER = Logger.getLogger(UserRoleDaoImpl.class);
	
	/**
	 * This method verify if a <code>SessionFactory</code> object exists 
	 * otherwise it is generated and returned.
	 * 
	 * @return a <code>SessionFactory</code> object
	 */
	public SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = HibernateUtils.getSessionFactory();
		}
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public UserRoleDTO getUserRoleById(int userRoleId) {
		LOGGER.info("UserRoleDaoImpl getUserRoleById has been called");
		UserRoleDTO userRoleDTO = new UserRoleDTO();
		Session session = getSessionFactory().openSession();
		try {
			UserRole userRole = (UserRole)session.createCriteria(UserRole.class).add(Restrictions.eq("userRoleName", userRoleId)).
					uniqueResult();
			if (userRole != null) {
				userRoleDTO = userRole.asDTO();			
			}
		} catch (Exception e) {
			LOGGER.error("Error: getting userRole by id failed!", e);
		} finally {
			session.close();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(HibernateUtils.SESSION_STOP);
			}
		}
		return userRoleDTO;
	}
	/**
	 * This is a method that returns a list with all UserRoles
	 */
	@Override
	public List<UserRoleDTO> getAllUserRole() {
		LOGGER.info("UserRoleDaoImpl getAllUserRole() has been called");
		Session session = getSessionFactory().openSession();
		List<UserRoleDTO> listUserRole = new ArrayList<UserRoleDTO>();
		try {
			List<UserRole> userRole = session.createCriteria(UserRole.class).list();
			
			for(UserRole newUserRole : userRole) {
				listUserRole.add(newUserRole.asDTO());
			}
		} catch (Exception e ) {
			LOGGER.error("Error: getting all userRoles");
		} finally {
			session.close();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(HibernateUtils.SESSION_STOP);
			}		
		}
		return listUserRole;
		
	}
}
