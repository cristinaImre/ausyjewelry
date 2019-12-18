package ro.ausy.jewelry.server.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ro.ausy.jewelry.commons.dto.UserRoleDTO;

/**
 * This class represents an UserRole database table.
 * @author cimre
 */
@Entity(name = "user_role")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 21487459L;
	
	/**
	 * This is the userRole id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userRoleId")
	private int userRoleId;
	
	/**
	 * This is the userRole name.
	 */
	@Basic
	@Column(name = "userRoleName")
	private String userRoleName;

	/**
	 * @param userRoleNameDTO
	 */
	public UserRole(final UserRoleDTO userRoleDTO) {
		this.userRoleId = userRoleDTO.getUserRoleId();
		this.userRoleName = userRoleDTO.getUserRoleName();
	}
	
	/**
	 * @return
	 * userRoleId.
	 */
	public final int getUserRoleId() {
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

	public UserRole() {
		super();
	}
	
	public UserRole(final int userRoleId, final String userRoleName) {
		super();
		this.userRoleId = userRoleId;
		this.userRoleName = userRoleName;
	}
	
	public UserRoleDTO asDTO() {
		return new UserRoleDTO(this.userRoleId, this.userRoleName);
	}
}
