package com.top.model;

/**
 * Authory entity. @author MyEclipse Persistence Tools
 */

public class Authory implements java.io.Serializable {

	// Fields

	private Integer roleId;
	private Users users;
	private Role role;

	// Constructors

	/** default constructor */
	public Authory() {
	}

	/** full constructor */
	public Authory(Users users, Role role) {
		this.users = users;
		this.role = role;
	}

	// Property accessors

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}