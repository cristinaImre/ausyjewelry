package ro.ausy.jewelry.commons.dto;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
* This is the Data Transfer Object for <code>User</code> object.
* @author Cristina Imre
*/
@Repository
public class UserDTO implements Serializable {

	/**
	 * UID
	 */
	private static final long serialVersionUID = 5005036701105477510L;

	/**
	 * This is the User's ID number which represents the primary key of this
	 * table.
	 */
	private int userDTOId;

	/**
	 * This is the userName that accesses the application.
	 */
	private String userName;
	
	private String password;
	
	private List<UserRoleDTO> userRoleDTOList;

	public int getUserDTOId() {
		return userDTOId;
	}

	public void setUserDTOId(int userDTOId) {
		this.userDTOId = userDTOId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public List<UserRoleDTO> getUserRoleDTOList() {
		return userRoleDTOList;
	}

	public void setUserRoleDTOList(List<UserRoleDTO> userRoleDTOList) {
		this.userRoleDTOList = userRoleDTOList;
	}

	public UserDTO() {
		super();
	}

	public UserDTO(int userDTOId, String userName, String password, List<UserRoleDTO> userRoleDTOList) {
		super();
		this.userDTOId = userDTOId;
		this.userName = userName;
		this.password = password;
		this.userRoleDTOList = userRoleDTOList;
	}

}
