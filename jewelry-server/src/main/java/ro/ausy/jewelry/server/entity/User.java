package ro.ausy.jewelry.server.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


import ro.ausy.jewelry.commons.dto.UserDTO;
import ro.ausy.jewelry.commons.dto.UserRoleDTO;

/**
 * This class represents a USER database table.
 * @author Cristina Imre
 */
@Entity(name = "user")
public class User implements Serializable {
	
	/**
	 * UID
	 */
	private static final long serialVersionUID = -8433037332873544963L;

	/**
	 * This is the User's ID number which represents the primary key of this
	 * table.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId", updatable = false)
	private int userId;

	/**
	 * This is the name of the user.
	 */
	@Basic
	@Column(name = "userName")
	private String userName;
	
	@Basic
	@Column(name = "password")
	private String password;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_role_user", joinColumns = {
			@JoinColumn(name = "userId", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "userRoleId", nullable = false, updatable = false) 	})
	private List<UserRole> userRoleList;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Column(name = "productId")
	private Set<Product> products = new HashSet<Product>(0);
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
	
	public List<UserRole> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<UserRole> userRoleList) {
		this.userRoleList = userRoleList;
	}

	public UserDTO asDTO() {
		final List<UserRoleDTO> userRoleDTOList = new ArrayList<UserRoleDTO>();
		for (final UserRole userRole : userRoleList) {
			userRoleDTOList.add(userRole.asDTO());
		}

		return new UserDTO(this.userId, this.userName, this.password, userRoleDTOList);
	}
}
