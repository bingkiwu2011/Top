package com.top.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.top.exception.MyException;
import com.top.model.jpa.Duihuan;

public interface DuihuanDAO extends PagingAndSortingRepository<Duihuan, Long>{
	@Query("select t from Duihuan t where buyerNick=?1")
	public List<Duihuan>getDuihuansByBuyerNick(String nick)throws MyException;
}  

