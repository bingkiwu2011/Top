/** 
* @Title: TradeServiceImplTest.java 
* @Package com.top.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* Copyright: Copyright (c)2009 
* Company:上海建周 
* @author bingki 
* @date 2012-9-29 上午10:36:11 
*@version 1.0 
*/
package com.top.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.top.exception.MyException;
import com.top.service.ITradeService;

/** 
 * @ClassName: TradeServiceImplTest 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author bingki 
 * @date 2012-9-29 上午10:36:11  
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "/test2Context.xml" })
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager")  
public class TradeServiceImplTest {

	@Resource
	private ITradeService tradeService;
	@Before
	public void setUp() throws Exception {
	}

	/** 
	 * @Title: tearDown 
	 * @Description:TODO(这里用一句话描述这个方法的作用) 
	 * @param @throws java.lang.Exception 设定文件 
	 * @return void 返回类型 
	 * @throws 
	 * @date 2012-9-29 上午10:36:11 
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.top.service.impl.TradeServiceImpl#getTradesBySellerNick(java.lang.String)}.
	 */
	@Test
	public void testGetTradesBySellerNick() {
		try {
			System.out.println(tradeService.getTradesByBuyerNick("bingki").size());
			System.out.println("1111111111111111");
			System.out.println(tradeService.getTradesByBuyerNick("bingki").size());
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.top.service.impl.TradeServiceImpl#getTradesByBuyerNick(java.lang.String)}.
	 */
	@Test
	public void testGetTradesByBuyerNick() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.top.service.impl.TradeServiceImpl#addTrade(com.top.model.jpa.Trade, com.top.model.jpa.Users)}.
	 */
	@Test
	public void testAddTrade() {
		fail("Not yet implemented");
	}

}
