/** 
 * @Title: UserInfo.java 
 * @Package com.top.security 
 * @Description: TODO(用一句话描述该文件做什么) 
 * Copyright: Copyright (c)2009 
 * Company:上海建周 
 * @author bingki 
 * @date 2012-9-29 下午4:33:30 
 *@version 1.0 
 */
package com.top.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * @ClassName: UserInfo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author bingki
 * @date 2012-9-29 下午4:33:30
 */
public class UserInfo extends User {
	private static final long serialVersionUID = -3893791280403803576L;

	public UserInfo(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
	
	private Long userId;
	private String username;
	private String name;
	private String phone;
	private Long level;
	private String email;
	private String uid;
	private Double iclass;
	private Double minprice;
	private Double maxprice;

	public Long getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public Long getLevel() {
		return level;
	}

	public String getEmail() {
		return email;
	}

	public String getUid() {
		return uid;
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

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setLevel(Long level) {
		this.level = level;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUid(String uid) {
		this.uid = uid;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", name=" + name + ", phone=" + phone + ", level=" + level + ", email=" + email + ", uid=" + uid + ", iclass=" + iclass + ", minprice=" + minprice + ", maxprice=" + maxprice + "]";
	}

}
