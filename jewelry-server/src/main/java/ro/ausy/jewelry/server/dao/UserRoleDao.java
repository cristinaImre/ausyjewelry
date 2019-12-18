package ro.ausy.jewelry.server.dao;

import java.util.List;

import ro.ausy.jewelry.commons.dto.UserRoleDTO;

public interface UserRoleDao {
	
	/**
	 * @return
	 * This method will return an UserRole by ID.
	 * @param userRoleId
	 * userRoleId.
	 */
	UserRoleDTO getUserRoleById(long userRoleId);
	
	/**
	 * @return
	 * This method will return all usersRole.
	 */
	List<UserRoleDTO> getAllUserRole();

}
