/** 
* @Title: ICustomerDAO.java 
* @Package com.top.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* Copyright: Copyright (c)2009 
* Company:上海建周 
* @author bingki 
* @date 2012-9-28 下午2:36:46 
*@version 1.0 
*/
package com.top.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.top.model.jpa.Customer;

/** 
 * @ClassName: ICustomerDAO 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author bingki 
 * @date 2012-9-28 下午2:36:46  
 */
public interface CustomerDAO extends PagingAndSortingRepository<Customer, Long>{
	public Customer findByName(String name);
}
