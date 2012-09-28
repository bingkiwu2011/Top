/** 
 * @Title: UsersServiceImpl.java 
 * @Package com.top.service.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * Copyright: Copyright (c)2009 
 * Company:上海建周 
 * @author bingki 
 * @date 2012-9-17 下午2:58:45 
 *@version 1.0 
 */
package com.top.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taobao.api.domain.User;
import com.top.api.service.TopApi;
import com.top.dao.UsersDAO;
import com.top.exception.MyException;
import com.top.model.jpa.Authory;
import com.top.model.jpa.Role;
import com.top.model.jpa.Users;
import com.top.service.IUsersService;
import com.top.util.ThreeDESCode;

/**
 * @ClassName: UsersServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author bingki
 * @date 2012-9-17 下午2:58:45
 */
@Service
@Transactional(readOnly = true)
public class UsersServiceImpl implements IUsersService {
	@Resource
	UsersDAO usersDAO;

	/**
	 * @Description: 根据用户Ncik查找卖家
	 */
	public Users findByUsername(String username) throws MyException {
		return usersDAO.findByUsername(username);
	}

	/**
	 * @Description: 新卖家购买应用,添加该卖家到Users表
	 */
	
	@Transactional(readOnly = false)
	public void addUsers(String sessionKey) throws MyException {
		User user = new TopApi().getSellerUser(sessionKey);
		Users users = new Users();
		users.setUsername(user.getNick());
		try {
			//密码是根据NICK 进行加密
			users.setPassword(ThreeDESCode.encryptThreeDESECB(user.getNick()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		users.setUserId(user.getUserId());
		users.setLevel(user.getSellerCredit().getLevel());
		users.setEnabled(1);
		users.setUid(user.getUid());

		Authory authory = new Authory();
		Role role = new Role();
		role.setId(3);//卖家 role

		authory.setRole_id(role.getId());
		authory.setUser_id(users.getUserId());

		users.setAuthory(authory);

		usersDAO.save(users);

	}

	/**
	 * @Description: 查找最新10个购买应用加入的卖家
	 */
	public List<Users> findTop10Sellers() throws MyException {
		return usersDAO.findTop10Sellers();
	}

	/**
	 * @Description: 根据UserId查找用户
	 */
	public Users findByUserId(Long userId) throws MyException {
		return usersDAO.findByUserId(userId);
	}

	public Users updateUsers(Users user)throws MyException{
		return usersDAO.save(user);
	}
}
