/** 
* @Title: UsersService.java 
* @Package com.BISms.dao.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* Copyright: Copyright (c)2009 
* Company:上海建周 
* @author bingki 
* @date 2011-12-16 下午04:43:45 
*@version 1.0 
*/
package com.top.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.top.dao.IUsersDAO;
import com.top.model.jpa.Users;
/** 
 * @ClassName: UsersService 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author bingki 
 * @date 2011-12-16 下午04:43:45  
 */
@Component
public class UsersDAO   {
	@Resource
	private IUsersDAO iUsersDAO;
	
	public Users getUserByUsername(String username) {
		//getHibernateTemplate().setCacheQueries(true);//存入二级缓存
		return iUsersDAO.findByUsername(username);
	}

}
