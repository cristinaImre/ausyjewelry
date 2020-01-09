package ro.ausy.jewelry.server.business;

import java.util.List;

import ro.ausy.jewelry.commons.dto.UserDTO;

/** 
 * This interface represents a manager that handles user operations.
 * @author Cristina Imre
 */
public interface UserManager {
	/**
	 * @param userId the user unique identifier
	 * @return a <code>userDTO</code> object
	 * This method will return an <code>UserDTO</code> object by ID.
	 */
	UserDTO getUserById(int userId);
	
	List<UserDTO> getAllUser();

	void insertUser(UserDTO userDTO);
	
	void deleteUser(UserDTO userDTO);
	
	UserDTO login(String userName, String password);
}
