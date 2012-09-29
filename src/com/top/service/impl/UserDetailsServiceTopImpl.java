package com.top.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.top.dao.UsersDAO;
import com.top.model.jpa.Users;
import com.top.security.UserInfo;

@Transactional(readOnly = true)
public class UserDetailsServiceTopImpl implements UserDetailsService {

	@Resource
	private UsersDAO userDao;


	/**
	 * 获取用户Details信息的回调函数.
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		Users user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("用户" + username + " 不存在");

		}
		Set<GrantedAuthority> grantedAuths = obtainGrantedAuthorities(user);

		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		UserInfo loginUsers= new UserInfo(user.getUsername(), user.getPassword(), user.getEnabled() == 1 ? true : false, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);
		loginUsers.setEmail(user.getEmail());
		loginUsers.setIclass(user.getIclass());
		loginUsers.setLevel(user.getLevel());
		loginUsers.setMinprice(user.getMinprice());
		loginUsers.setMaxprice(user.getMaxprice());
		loginUsers.setName(user.getName());
		loginUsers.setPhone(user.getPhone());
		loginUsers.setUid(user.getUid());
		loginUsers.setUserId(user.getUserId());
		loginUsers.setUsername(username);
		return loginUsers;
	}

	/**
	 * 获得用户所有角色的权限集合.
	 */
	private Set<GrantedAuthority> obtainGrantedAuthorities(Users user) {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		authSet.add(new SimpleGrantedAuthority(user.getAuthory().getRole().getName()));
		return authSet;
	}

}
