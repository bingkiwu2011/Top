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
package com.top.Notify;

import com.taobao.api.domain.NotifyItem;
import com.taobao.api.domain.NotifyRefund;
import com.taobao.api.domain.NotifyTrade;

/** 
 * @ClassName: ProductMessage 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author bingki 
 * @date 2012-8-28 下午5:35:55  
 */
public class ProductNotify extends Thread {
	private String message;
	public ProductNotify(String message){
		this.message=message;
	}
	public void run(){
		try {
			//根据本应用需求，只处理交易类 且 交易状态是完成的通知信息
			Object object=MessageDecode.decodeMsg(message);			
			if(object instanceof NotifyItem){//商品
				//NotifyItem item=(NotifyItem)object;
			}else if (object instanceof NotifyRefund) {//退款
			//	NotifyRefund item=(NotifyRefund)object;
			}else if (object instanceof NotifyTrade) {//交易
				NotifyTrade item=(NotifyTrade)object;
				if(item.getStatus().equals("TradeSuccess")){
					//逻辑
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
