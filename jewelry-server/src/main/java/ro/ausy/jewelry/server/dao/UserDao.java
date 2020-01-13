package ro.ausy.jewelry.server.dao;

import java.util.List;

import ro.ausy.jewelry.commons.dto.UserDTO;

/**
* This interface represents the abstraction of user Data Access Object.
* @author Cristina Imre
*/
public interface UserDao {
	
	UserDTO getUserById(int userId);
	
	UserDTO getUserByName(String userName);
	
	List<UserDTO> getAllUser();

	void insertUser(UserDTO userDTO);
	
	void deleteUser(UserDTO userDTO);
	
	UserDTO login(String userName, String password);
}
