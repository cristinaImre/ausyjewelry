package ro.ausy.jewelry.server.dao;

import java.util.List;

import ro.ausy.jewelry.commons.dto.UserDTO;

/**
* This interface represents the abstraction of user Data Access Object.
* @author Cristina Imre
*/
public interface UserDao {
	
	/**
	 * @param userId the user unique identifier
	 * @return a <code>userDTO</code> object
	 * This method will return an <code>UserDTO</code> object by ID.
	 */
	UserDTO getUserById(long userId);
	
	/**
	 * @return
	 * This method will return all users.
	 */
	List<UserDTO> getAllUser();

	void insertUser(UserDTO userDTO);
	
	void deleteUser(UserDTO userDTO);
	
}
