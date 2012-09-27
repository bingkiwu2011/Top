/** 
 * @Title: NotifyUtil.java 
 * @Package com.top.Notify 
 * @Description: TODO(用一句话描述该文件做什么) 
 * Copyright: Copyright (c)2009 
 * Company:上海建周 
 * @author bingki 
 * @date 2012-9-4 下午4:35:29 
 *@version 1.0 
 */
package com.top.api.service;

import java.util.List;

import javax.annotation.Resource;

import com.taobao.api.domain.DiscardInfo;
import com.taobao.api.domain.NotifyTrade;
import com.top.exception.MyException;
import com.top.service.IUsersService;

public class NotifyService {
	@Resource
	private IUsersService usersService;
	/**
	 * @Description 通知信息丢失重新找回
	 * @return void 返回类型
	 * @date 2012-9-27 下午2:09:40
	 */
	public void discardinfo() throws MyException {
		TopApi topApi=new TopApi();
		try {
			List<DiscardInfo> discardInfos =topApi.discardinfo();
			if (discardInfos != null) {
				for (DiscardInfo discardInfo : discardInfos) {
					// 因为应用只接口交易成功的交易类通知，所以只调用交易增量接口
					String username=usersService.findByUserId(discardInfo.getUserId()).getUsername();
					List<NotifyTrade>notifyTrades=topApi.getIncrementTrades(username);
					for(NotifyTrade notifyTrade:notifyTrades){
						
					}
				}
			}
		} catch (Exception e) {
		}

	}

	public static void main(String[] args) throws MyException {
		NotifyService notifyUtil = new NotifyService();

		notifyUtil.discardinfo();
	}

}
