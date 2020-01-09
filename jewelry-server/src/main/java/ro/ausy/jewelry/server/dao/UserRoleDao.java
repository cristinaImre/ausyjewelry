package ro.ausy.jewelry.server.dao;

import java.util.List;

import ro.ausy.jewelry.commons.dto.UserRoleDTO;

public interface UserRoleDao {
	
	UserRoleDTO getUserRoleById(int userRoleId);
	
	List<UserRoleDTO> getAllUserRole();

}
