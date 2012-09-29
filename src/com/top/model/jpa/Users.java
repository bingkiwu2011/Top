package com.top.model.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "users", catalog = "top")
public class Users implements java.io.Serializable {

	private static final long serialVersionUID = -5740016950903957915L;
	
	@Id
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
	@Column(name = "email",nullable = true, length = 50)
	private String email;
	@Column(name = "uid", nullable = true, length = 50)
	private String uid;
	@Column(name = "iclass", nullable = true, precision = 4)
	private Double iclass;
	@Column(name = "minprice", nullable = true, precision = 10)
	private Double minprice;
	@Column(name = "maxprice", nullable = true, precision = 10)
	private Double maxprice;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
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

	public Double getIclass() {
		return iclass;
	}

	public Double getMinprice() {
		return minprice;
	}

	public Double getMaxprice() {
		return maxprice;
	}

	public void setIclass(Double iclass) {
		this.iclass = iclass;
	}

	public void setMinprice(Double minprice) {
		this.minprice = minprice;
	}

	public void setMaxprice(Double maxprice) {
		this.maxprice = maxprice;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}