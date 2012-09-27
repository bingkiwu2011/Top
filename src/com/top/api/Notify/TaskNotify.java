/** 
* @Title: ProductMessage.java 
* @Package com.top.info 
* @Description: TODO(用一句话描述该文件做什么) 
* Copyright: Copyright (c)2009 
* Company:上海建周 
* @author bingki 
* @date 2012-8-28 下午5:35:55 
*@version 1.0 
*/
package com.top.api.Notify;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.top.api.Topats.SoldsDetail;


/** 
 * @ClassName: ProductMessage 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author bingki 
 * @date 2012-8-28 下午5:35:55  
 */
public class TaskNotify extends Thread {
	private static Log log = LogFactory.getLog(TaskNotify.class);
	private String message;
	public TaskNotify(String message){
		this.message=message;
	}
	public void run(){
		try {
			JSONObject jsonObject=JSON.parseObject(message);
			new SoldsDetail().getTaskResult(Long.valueOf(jsonObject.getString("task_id")));
		} catch (Exception e) {
			log.error(e);
		}
	}
}
