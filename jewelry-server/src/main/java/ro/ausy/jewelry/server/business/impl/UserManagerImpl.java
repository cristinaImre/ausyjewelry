package ro.ausy.jewelry.server.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import ro.ausy.jewelry.commons.dto.UserDTO;
import ro.ausy.jewelry.server.business.UserManager;
import ro.ausy.jewelry.server.dao.UserDao;

/**
 * This class represents a manager that implements the methods from <code>UserManager</code> interface.
 * @author Cristina Imre 
 */
@Repository
public class UserManagerImpl implements UserManager {
	
	final ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	private transient UserDao userDao = appContext.getBean(UserDao.class);
	
	@Override
	public UserDTO getUserById(int userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public List<UserDTO> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public void insertUser(UserDTO userDTO) {
		userDao.insertUser(userDTO);
	}
	
	@Override
	public void deleteUser(UserDTO userDTO) {
		userDao.deleteUser(userDTO);
	}

	@Override
	public UserDTO login(String userName, String password) {
		return userDao.login(userName, password);
	}
		
}
