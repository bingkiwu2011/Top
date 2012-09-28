/** 
* @Title: DuihuanServiceImpl.java 
* @Package com.top.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* Copyright: Copyright (c)2009 
* Company:上海建周 
* @author bingki 
* @date 2012-9-28 下午2:31:45 
*@version 1.0 
*/
package com.top.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.top.dao.DuihuanDAO;
import com.top.exception.MyException;
import com.top.model.jpa.Duihuan;
import com.top.service.IDuihuanService;

/** 
 * @ClassName: DuihuanServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author bingki 
 * @date 2012-9-28 下午2:31:45  
 */
@Service
@Transactional(readOnly = true)
public class DuihuanServiceImpl implements IDuihuanService {
	@Resource
	DuihuanDAO duihuanDAO;
	
	
	public List<Duihuan> getDuihuansByBuyerNick(String nick) throws MyException {
		return duihuanDAO.getDuihuansByBuyerNick(nick);
	}

	@Transactional(readOnly = false)
	public Duihuan addDuihuan(Duihuan duihuan) throws MyException {
		return duihuanDAO.save(duihuan);
	}

}
