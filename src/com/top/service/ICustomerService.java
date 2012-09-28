/** 
* @Title: ICustomerService.java 
* @Package com.top.service 
* @Description: TODO(用一句话描述该文件做什么) 
* Copyright: Copyright (c)2009 
* Company:上海建周 
* @author bingki 
* @date 2012-9-28 下午2:38:17 
*@version 1.0 
*/
package com.top.service;

import com.top.exception.MyException;
import com.top.model.jpa.Customer;

/** 
 * @ClassName: ICustomerService 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author bingki 
 * @date 2012-9-28 下午2:38:17  
 */
public interface ICustomerService {
	public Customer getCustomerByName(String name)throws MyException;
	public Customer saveOrUpdateCustomer(Customer customer)throws MyException;
}
