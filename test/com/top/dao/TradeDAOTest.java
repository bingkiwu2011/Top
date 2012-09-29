/** 
* @Title: TradeDAOTest.java 
* @Package com.top.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* Copyright: Copyright (c)2009 
* Company:上海建周 
* @author bingki 
* @date 2012-9-28 下午2:16:01 
*@version 1.0 
*/
package com.top.dao;

import javax.annotation.Resource;



import org.hibernate.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.top.exception.MyException;

/** 
 * @ClassName: TradeDAOTest 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author bingki 
 * @date 2012-9-28 下午2:16:01  
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "/test2Context.xml" })
public class TradeDAOTest  {
	@Resource
	private TradeDAO tradeDAO;
	@Before
	public void setUp() throws Exception {
	}

	/** 
	 * @Title: tearDown 
	 * @Description:TODO(这里用一句话描述这个方法的作用) 
	 * @param @throws java.lang.Exception 设定文件 
	 * @return void 返回类型 
	 * @throws 
	 * @date 2012-9-28 下午2:16:02 
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
	}

}
