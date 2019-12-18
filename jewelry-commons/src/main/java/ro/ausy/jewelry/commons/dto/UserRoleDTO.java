package ro.ausy.jewelry.commons.dto;

import java.io.Serializable;

/**
 * This is the Data Transfer Object for <code>User</code> object.
 * 
 * @author cimre
 *
 */
public class UserRoleDTO implements Serializable {
	
	/**
	 * UID.
	 */
	private static final long serialVersionUID = -21487547895L;
	
	/**
	 * This is UserRole's ID number which represents the primary key of this table.
	 */
	private int userRoleId;
	
	/**
	 * This is a String userRoleName.
	 */
	private String userRoleName;

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserRoleName() {
		return userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}
	
	public UserRoleDTO() {
		super();
	}
	
	public UserRoleDTO(final int userRoleId, final String userRoleName) {
		this.userRoleId = userRoleId;
		this.userRoleName = userRoleName;
	}
		
	

}
