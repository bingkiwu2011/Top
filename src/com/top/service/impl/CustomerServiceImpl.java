/** 
* @Title: CustomerServiceImpl.java 
* @Package com.top.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* Copyright: Copyright (c)2009 
* Company:上海建周 
* @author bingki 
* @date 2012-9-28 下午2:39:23 
*@version 1.0 
*/
package com.top.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.top.dao.CustomerDAO;
import com.top.exception.MyException;
import com.top.model.jpa.Customer;
import com.top.service.ICustomerService;

/** 
 * @ClassName: CustomerServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author bingki 
 * @date 2012-9-28 下午2:39:23  
 */
@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements ICustomerService {
	@Resource
	CustomerDAO customerDAO;

	public Customer getCustomerByName(String name) throws MyException {
		return customerDAO.findByName(name);
	}

	@Transactional(readOnly = false)
	public Customer saveOrUpdateCustomer(Customer customer)throws MyException{
		return customerDAO.save(customer);
	}
}
