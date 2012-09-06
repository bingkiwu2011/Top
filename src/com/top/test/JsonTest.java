/** 
* @Title: JsonTest.java 
* @Package com.top.test 
* @Description: TODO(用一句话描述该文件做什么) 
* Copyright: Copyright (c)2009 
* Company:上海建周 
* @author bingki 
* @date 2012-8-29 下午4:29:12 
*@version 1.0 
*/
package com.top.test;

import org.codehaus.jackson.annotate.JsonBackReference;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/** 
 * @ClassName: JsonTest 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author bingki 
 * @date 2012-8-29 下午4:29:12  
 */
public class JsonTest {

	/** 
	 * @Title: main 
	 * @Description:TODO(这里用一句话描述这个方法的作用) 
	 * @param @param args 设定文件 
	 * @return void 返回类型 
	 * @throws 
	 * @date 2012-8-29 下午4:29:12 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			JSONObject jsonObject=JSON.parseObject("{'w2_expires_in': 1800,'taobao_user_id': '20500435'}");
			System.out.println(jsonObject.getString("taobao_user_id"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
