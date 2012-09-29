/** 
 * @Title: TradeService.java 
 * @Package com.top.service.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * Copyright: Copyright (c)2009 
 * Company:上海建周 
 * @author bingki 
 * @date 2012-9-27 下午6:05:16 
 *@version 1.0 
 */
package com.top.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.top.dao.CustomerDAO;
import com.top.dao.TradeDAO;
import com.top.exception.MyException;
import com.top.model.jpa.Customer;
import com.top.model.jpa.Trade;
import com.top.model.jpa.Users;
import com.top.service.ITradeService;

@Service
@Transactional(readOnly = true)
public class TradeServiceImpl implements ITradeService {
	@Resource
	private TradeDAO tradeDAO;
	@Resource
	private CustomerDAO customerDAO;

	@Cacheable(value = { "true" })
	public List<Trade> getTradesBySellerNick(String nick) throws MyException {
		return tradeDAO.getTradesBySellerNick(nick);
	}

	public List<Trade> getTradesByBuyerNick(String nick) throws MyException {
		return tradeDAO.getTradesByBuyerNick(nick);
	}

	@Transactional(readOnly = false)
	public Trade addTrade(Trade trade, Users user) throws MyException {
		Customer customer = customerDAO.findByName(trade.getBuyerNick());
		if (customer == null) {
			customer = new Customer();
			customer.setName(trade.getBuyerNick());
			customer.setIntegral(0d);
		}
		customer.setIntegral(customer.getIntegral() + trade.getPayment() * user.getIclass());
		customerDAO.save(customer);
		return tradeDAO.save(trade);
	}
}
