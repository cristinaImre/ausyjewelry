package ro.ausy.jewelry.server.business;

import java.util.List;

import ro.ausy.jewelry.commons.dto.UserRoleDTO;

/**
 * This interfec represents a manager that handles user operations.
 * 
 * @author cimre
 *
 */
public interface UserRoleManager {
	
	UserRoleDTO getUserRoleById(int userRoleId);
	
	List<UserRoleDTO> getAllUserRole();

}
