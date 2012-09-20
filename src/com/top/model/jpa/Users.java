package com.top.model.jpa;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "users", catalog = "top")
public class Users implements java.io.Serializable {

	private static final long serialVersionUID = -5740016950903957915L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@Column(name = "user_id", unique = true, nullable = false)
	private Long userId;
	@Column(name = "username", nullable = false, length = 30)
	private String username;
	@Column(name = "password", nullable = false, length = 100)
	private String password;
	@Column(name = "name", nullable = true, length = 20)
	private String name;
	@Column(name = "phone", nullable = true, length = 11)
	private String phone;
	@Column(name = "enabled", nullable = false)
	private Integer enabled;
	@Column(name = "level", nullable = false)
	private Long level;
	@Column(name = "uid", nullable = true, length = 50)
	private String uid;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private Authory authory;

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Authory getAuthory() {
		return authory;
	}

	public void setAuthory(Authory authory) {
		this.authory = authory;
	}

	public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}