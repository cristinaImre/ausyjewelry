package ro.ausy.jewelry.server.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ro.ausy.jewelry.commons.dto.UserDTO;
import ro.ausy.jewelry.commons.dto.UserRoleDTO;
import ro.ausy.jewelry.server.dao.UserDao;
import ro.ausy.jewelry.server.entity.User;
import ro.ausy.jewelry.server.entity.UserRole;
import ro.ausy.jewelry.server.utils.HibernateUtils;

/**
* This class implements the user methods that the client will be able to call
* through <code>UserManager</code> object.
* 
* @author Cristina Imre
*/
@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	/**
	 * This is the Hibernate locale session that allows you to connect to
	 * the database.
	 */
	private SessionFactory sessionFactory;

	/**
	 * The logging object.
	 */
	private static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

	/**
	 * This method verify if a <code>SessionFactory</code> object exists otherwise it is generated and returned.
	 * @return a <code>SessionFactory</code> object
	 */
	public SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			sessionFactory = HibernateUtils.getSessionFactory();
		}

		return sessionFactory;
	}
	
	/**
	 * This method set a Hibernate session to a local session.
	 * @param sessionFactory the Hibernate session
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insertUser(UserDTO userDTO) {
		LOGGER.info("UserDaoImpl insertUser(UserDTO userDTO) has been called");

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			User user = new User();
			user.setUserName(userDTO.getUserName());
			user.setPassword(userDTO.getPassword());
			
			List<UserRole> userRoleList = new ArrayList<UserRole>();
			List<UserRoleDTO> userRoleDTOs = userDTO.getUserRoleDTOList();
			for(UserRoleDTO userRoleDTO : userRoleDTOs) {
			  userRoleList.add(new UserRole(userRoleDTO));
			}
			user.setUserRoleList(userRoleList);
			 
			session.saveOrUpdate(user);
			tx.commit();

		} catch (Exception e) {
			LOGGER.error("Error: getting user by userName failed! ", e);
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(HibernateUtils.SESSION_STOP);
			}
		}
	}

	@Override
	public UserDTO getUserById(int userId) {
		LOGGER.info("UserDaoImpl getUserById(Long id) has been called");

		UserDTO userDTO = new UserDTO();
		Session session = getSessionFactory().openSession();

		try {
			User user = (User) session.createCriteria(User.class).add(Restrictions.eq("id", userId)).uniqueResult();

			if (user != null) {
				return user.asDTO();
			}
		} catch (Exception e) {
			LOGGER.error("Error: getting user by id failed! ", e);
		} finally {
			session.close();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(HibernateUtils.SESSION_STOP);
			}
		}

		return userDTO;
	}
	
	@Override
	public UserDTO getUserByName(final String userName) {
		LOGGER.info("UserDaoImpl getUserByName(String userName) has been called");

		final UserDTO userDTO = new UserDTO();
		Session session = getSessionFactory().openSession();

		try {
			User user = (User) session.createCriteria(User.class).add(Restrictions.eq("userName", userName))
					.uniqueResult();

			if (user != null) {
				return user.asDTO();
			}
		} catch (Exception e) {
			LOGGER.error("Error: getting user by userName failed! ", e);
		} finally {
			session.close();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(HibernateUtils.SESSION_STOP);
			}
		}

		return userDTO;
	}

	@Override
	public List<UserDTO> getAllUser() {
		LOGGER.info("UserDaoImpl getAll() has been called");
		Session session = getSessionFactory().openSession();
		final List<UserDTO> userlist = new ArrayList<UserDTO>();
		try {
			@SuppressWarnings("unchecked")
			List<User> users = session.createCriteria(User.class).list();

			for (User userHere : users) {
				userlist.add(userHere.asDTO());
			}
		} catch (Exception e) {
			LOGGER.error("Error: getting all users");
		} finally {
			session.close();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(HibernateUtils.SESSION_STOP);
			}
		}
		return userlist;	
	}

	@Override
	public void deleteUser(UserDTO userDTO) {
		LOGGER.info("UserDaoImpl deleteUser() has been called");
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			User user = new User();
			user.setUserId(userDTO.getUserDTOId());
			session.delete(user);
			tx.commit();
		} catch (Exception e) {
			LOGGER.error("Error: deleting user failed", e);
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(HibernateUtils.SESSION_STOP);
			}
		}		
		}
	@Override
	public UserDTO login(String userName, String password) {
		LOGGER.info("UserDaoImpl login(String userName, String password) has been called");
		UserDTO userDTO = new UserDTO();
		Session session = getSessionFactory().openSession();
		try {
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("userName", userName));
			criteria.add(Restrictions.eq("password", password));
			User user = (User) criteria.uniqueResult();
			if(user != null){
				userDTO = user.asDTO();
			}
		} catch(Exception e) {
			LOGGER.error("Error: login failed", e);
		} finally {
			session.close();
			if(LOGGER.isDebugEnabled()) {
				LOGGER.debug(HibernateUtils.SESSION_STOP);
			}
		}
		return userDTO;
	
	}
	

}

