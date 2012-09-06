/** 
* @Title: UsersService.java 
* @Package com.top.api.dao.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* Copyright: Copyright (c)2009 
* Company:上海建周 
* @author bingki 
* @date 2012-3-15 下午03:40:15 
*@version 1.0 
*/
package com.top.api.dao.impl;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.User;
import com.taobao.api.request.UserGetRequest;
import com.taobao.api.response.UserGetResponse;
import com.top.common.Constants;


public class UsersApiService {

	public User getUserFromNick(String nick){
		TaobaoClient client = new DefaultTaobaoClient(
				"http://gw.api.taobao.com/router/rest", Constants.FRONT_APP_KEY, Constants.FRONT_APP_SECRET);
		UserGetRequest req = new UserGetRequest();
		req.setFields("user_id,uid,nick,sex,buyer_credit,seller_credit,location,created,last_visit,birthday,type,status,alipay_no,alipay_account,alipay_account,email,consumer_protection,alipay_bind");
		req.setNick(nick);
		try {
			UserGetResponse response = client.execute(req);
			User user=response.getUser();
			return user;
		} catch (ApiException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) {
		UsersApiService uas=new UsersApiService();
		System.out.println(uas.getUserFromNick("bingki").getLocation().getCity());

	}

}
