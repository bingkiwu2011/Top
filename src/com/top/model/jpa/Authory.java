package com.top.model.jpa;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Authory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "authory", catalog = "top")
public class Authory implements java.io.Serializable {

	private static final long serialVersionUID = 3519617071526800625L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	private Long user_id;
	private int role_id;

	@OneToOne
	@JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
	private Users users;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false, insertable = false, updatable = false)
	private Role role;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
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