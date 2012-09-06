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
package com.top.Notify;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.DiscardInfo;
import com.taobao.api.request.CometDiscardinfoGetRequest;
import com.taobao.api.request.IncrementTradesGetRequest;
import com.taobao.api.response.CometDiscardinfoGetResponse;
import com.taobao.api.response.IncrementTradesGetResponse;
import com.top.common.Constants;
import com.top.exception.MyException;

/**
 * @ClassName: NotifyUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author bingki
 * @date 2012-9-4 下午4:35:29
 */
public class NotifyUtil {
	private TaobaoClient client = new DefaultTaobaoClient(Constants.URL, Constants.BACK_APP_KEY, Constants.BACK_APP_SECRET);
	private static Log log = LogFactory.getLog(NotifyUtil.class);
	// 获取哪些用户丢弃了消息
	public void discardinfo() throws MyException {
		CometDiscardinfoGetRequest req = new CometDiscardinfoGetRequest();

		long nCurrentTime = System.currentTimeMillis();
		CometDiscardinfoGetResponse response=null;
		try {
			req.setStart(new Date(nCurrentTime - 1000 * 60 * 55));
			response = client.execute(req);
			List<DiscardInfo>discardInfos=response.getDiscardInfoList();
			if(discardInfos!=null){
				for(DiscardInfo discardInfo:discardInfos){
					//因为应用只接口交易成功的交易类通知，所以只调用交易增量接口
					tradesGetByUserID(discardInfo.getUserId());
					log.info(discardInfo.getUserId()+",交易增量信息!");
				}
			}
		} catch (Exception e) {
			throw new MyException("discardinfo:"+response.getBody(), e);
		}

	}
	
	private void tradesGetByUserID(Long userID)throws MyException{
		//根据用户ID，查询用户名
		
		IncrementTradesGetRequest req=new IncrementTradesGetRequest();
		req.setNick("我是一个用户名");
		req.setStatus("TradeSuccess");		
		req.setPageNo(1L);
		req.setPageSize(40L);
		IncrementTradesGetResponse response=null;
		try {
			response = client.execute(req);
			System.out.println(response.getBody());
		} catch (Exception e) {
			throw new MyException("error tradesGet:"+response.getBody(),e);
		}
	}

	public static void main(String[] args) throws MyException {
		NotifyUtil notifyUtil=new NotifyUtil();
		
		notifyUtil.discardinfo();
	}

}
