package com.top.test;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.UserGetRequest;
import com.taobao.api.response.UserGetResponse;

public class TestBack {

	public void apiTest(String sessionKey) {
		TaobaoClient client = new DefaultTaobaoClient(
				"http://gw.api.taobao.com/router/rest",
				"12541444", "19ea11815b62ee14b763eb156b93e96b");
		UserGetRequest req = new UserGetRequest();
		req.setFields("user_id,uid,nick,sex,buyer_credit,seller_credit,location,created,last_visit,birthday,type,status,alipay_no,alipay_account,alipay_account,email,consumer_protection,alipay_bind");
		req.setNick("bingki");
		try {
			UserGetResponse response = client.execute(req, sessionKey);
			System.out.println(response.getBody());
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestBack test = new TestBack();
		test.apiTest("6100d156b48abf2bb4df6ec1fe85fd231e687db446e9ff420500435");

	}

}
