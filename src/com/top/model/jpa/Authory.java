package com.top.model.jpa;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Authory entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "authory", catalog = "top")
public class Authory implements java.io.Serializable {

	// Fields

	private AuthoryId id;
	private Users users;
	private Role role;

	// Constructors

	/** default constructor */
	public Authory() {
	}

	/** full constructor */
	public Authory(AuthoryId id, Users users, Role role) {
		this.id = id;
		this.users = users;
		this.role = role;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "roleId", column = @Column(name = "role_id", nullable = false)), @AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false)) })
	public AuthoryId getId() {
		return this.id;
	}

	public void setId(AuthoryId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false, insertable = false, updatable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}