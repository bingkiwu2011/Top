/** 
* @Title: Test.java 
* @Package com.top.info 
* @Description: TODO(用一句话描述该文件做什么) 
* Copyright: Copyright (c)2009 
* Company:上海建周 
* @author bingki 
* @date 2012-8-28 下午2:50:29 
*@version 1.0 
*/
package com.top.Notify;

import com.taobao.api.internal.stream.Configuration;
import com.taobao.api.internal.stream.TopCometStream;
import com.taobao.api.internal.stream.TopCometStreamFactory;
import com.taobao.api.internal.stream.connect.ConnectionLifeCycleListener;
import com.taobao.api.internal.stream.message.TopCometMessageListener;
import com.top.common.Constants;

/** 
 * @ClassName: Test 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author bingki 
 * @date 2012-8-28 下午2:50:29  
 */
public class Test {

	/** 
	 * @Title: main 
	 * @Description:TODO(这里用一句话描述这个方法的作用) 
	 * @param @param args 设定文件 
	 * @return void 返回类型 
	 * @throws 
	 * @date 2012-8-28 下午2:50:29 
	 */
	public static void main(String[] args) {
		Configuration conf = new Configuration(Constants.BACK_APP_KEY,Constants.BACK_APP_SECRET,null);
		 
		TopCometStream stream = new TopCometStreamFactory(conf).getInstance();
		stream.setConnectionListener(new MyConnectionLifeCycleListener());
		stream.setMessageListener(new MyTopCometMessageListener());
		 
		stream.start();


	}

}
