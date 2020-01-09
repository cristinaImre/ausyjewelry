package ro.ausy.jewelry.server.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import ro.ausy.jewelry.commons.dto.UserRoleDTO;
import ro.ausy.jewelry.server.business.UserRoleManager;
import ro.ausy.jewelry.server.dao.UserDao;
import ro.ausy.jewelry.server.dao.UserRoleDao;

@Repository
public class UserRoleManagerImpl implements UserRoleManager {
	

	final ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	private transient UserRoleDao userRoleDao = appContext.getBean(UserRoleDao.class);
	
	@Override
	public final UserRoleDTO getUserRoleById(final int userRoleId) {
		return userRoleDao.getUserRoleById(userRoleId);	
	}
	
	@Override
	public final List<UserRoleDTO> getAllUserRole() {
		return userRoleDao.getAllUserRole();
	}
	

}
