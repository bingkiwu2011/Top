/** 
* @Title: IDuihuanService.java 
* @Package com.top.service 
* @Description: TODO(用一句话描述该文件做什么) 
* Copyright: Copyright (c)2009 
* Company:上海建周 
* @author bingki 
* @date 2012-9-27 下午5:52:23 
*@version 1.0 
*/
package com.top.service;

import java.util.List;

import com.top.exception.MyException;
import com.top.model.jpa.Duihuan;

/** 
 * @ClassName: IDuihuanService 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author bingki 
 * @date 2012-9-27 下午5:52:23  
 */
public interface IDuihuanService {
	public List<Duihuan>getDuihuansByBuyerNick(String nick)throws MyException;
	public Duihuan addDuihuan(Duihuan duihuan) throws MyException;
}
