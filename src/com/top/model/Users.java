package com.top.model;

import java.util.HashSet;
import java.util.Set;


/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String username;
	private String password;
	private String name;
	private String phone;
	private Integer enabled;
	private Integer integral;
	private Set<Authory> authories = new HashSet<Authory>();

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String username, String password, String name, String phone,
			Integer enabled, Integer integral) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.enabled = enabled;
		this.integral = integral;
	}

	/** full constructor */
	public Users(String username, String password, String name, String phone,
			Integer enabled, Integer integral, Set authories) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.enabled = enabled;
		this.integral = integral;
		this.authories = authories;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
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

	public Integer getIntegral() {
		return this.integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Set<Authory> getAuthories() {
		return this.authories;
	}

	public void setAuthories(Set<Authory> authories) {
		this.authories = authories;
	}

}