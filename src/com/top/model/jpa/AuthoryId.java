package com.top.model.jpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * AuthoryId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AuthoryId implements java.io.Serializable {

	// Fields

	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = -1748338116000820316L;
	private Integer roleId;
	private Integer userId;

	// Constructors

	/** default constructor */
	public AuthoryId() {
	}

	/** full constructor */
	public AuthoryId(Integer roleId, Integer userId) {
		this.roleId = roleId;
		this.userId = userId;
	}

	// Property accessors

	@Column(name = "role_id", nullable = false)
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AuthoryId))
			return false;
		AuthoryId castOther = (AuthoryId) other;

		return ((this.getRoleId() == castOther.getRoleId()) || (this.getRoleId() != null && castOther.getRoleId() != null && this.getRoleId().equals(castOther.getRoleId()))) && ((this.getUserId() == castOther.getUserId()) || (this.getUserId() != null && castOther.getUserId() != null && this.getUserId().equals(castOther.getUserId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getRoleId() == null ? 0 : this.getRoleId().hashCode());
		result = 37 * result + (getUserId() == null ? 0 : this.getUserId().hashCode());
		return result;
	}

}