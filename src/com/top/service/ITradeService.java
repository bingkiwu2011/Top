/** 
* @Title: ITradeService.java 
* @Package com.top.service 
* @Description: TODO(用一句话描述该文件做什么) 
* Copyright: Copyright (c)2009 
* Company:上海建周 
* @author bingki 
* @date 2012-9-27 下午5:52:07 
*@version 1.0 
*/
package com.top.service;

import java.util.List;

import com.top.exception.MyException;
import com.top.model.jpa.Trade;
import com.top.model.jpa.Users;

/** 
 * @ClassName: ITradeService 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author bingki 
 * @date 2012-9-27 下午5:52:07  
 */
public interface ITradeService {
	public List<Trade>getTradesBySellerNick(String nick)throws MyException;
	public List<Trade>getTradesByBuyerNick(String nick)throws MyException;
	public Trade addTrade(Trade trade,Users user) throws MyException;
}
