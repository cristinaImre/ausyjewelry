package ro.ausy.jewelry.server.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private transient UserDao userDao;
	
	@Override
	public UserDTO getUserById(int userId) {
		return userDao.getUserById(userId);
	}
	
	@Override
	public UserDTO getUserByName(String userName) {
		return userDao.getUserByName(userName);
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
