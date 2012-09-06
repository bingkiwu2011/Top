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

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.top.dao.IUsersDAO;
import com.top.model.Users;
/** 
 * @ClassName: UsersService 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author bingki 
 * @date 2011-12-16 下午04:43:45  
 */
@Repository
public class UsersDAO extends HibernateDaoSupport implements IUsersDAO {
	@Resource 
    public void setSessionFactoryOverride(SessionFactory sessionFactory)   
    {   
        super.setSessionFactory(sessionFactory);   
    }  
	
	@SuppressWarnings("rawtypes")
	public Users getUserByUsername(String username) {
		Users user=new Users();
		user.setUsername(username);
		//getHibernateTemplate().setCacheQueries(true);//存入二级缓存
		List list=getHibernateTemplate().findByExample(user);
		if(null!=list&&list.size()>0)
			return  (Users) list.get(0);
		else
			return  null;
	}

}
