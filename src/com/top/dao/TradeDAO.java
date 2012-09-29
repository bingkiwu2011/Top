package com.top.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.top.exception.MyException;
import com.top.model.jpa.Trade;

public interface TradeDAO extends PagingAndSortingRepository<Trade, Long>{
	@Query("select t from Trade t where sellerNick=?1")
	public List<Trade>getTradesBySellerNick(String nick)throws MyException;
	
	@Query("select t from Trade t where buyerNick=?1")
	public List<Trade>getTradesByBuyerNick(String nick)throws MyException;
	
	//public Trade findById(int id);
	
	
}  

