package com.top.api.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.DiscardInfo;
import com.taobao.api.domain.NotifyTrade;
import com.taobao.api.domain.User;
import com.taobao.api.request.CometDiscardinfoGetRequest;
import com.taobao.api.request.IncrementCustomerPermitRequest;
import com.taobao.api.request.IncrementCustomerStopRequest;
import com.taobao.api.request.IncrementTradesGetRequest;
import com.taobao.api.request.TopatsTradesSoldGetRequest;
import com.taobao.api.request.UserGetRequest;
import com.taobao.api.request.UserSellerGetRequest;
import com.taobao.api.response.CometDiscardinfoGetResponse;
import com.taobao.api.response.IncrementCustomerPermitResponse;
import com.taobao.api.response.IncrementCustomerStopResponse;
import com.taobao.api.response.IncrementTradesGetResponse;
import com.taobao.api.response.TopatsTradesSoldGetResponse;
import com.taobao.api.response.UserGetResponse;
import com.taobao.api.response.UserSellerGetResponse;
import com.top.common.Constants;
import com.top.exception.MyException;

public class TopApi {
	// private static Log log = LogFactory.getLog(TopApi.class);

	private TaobaoClient client = new DefaultTaobaoClient(Constants.URL, Constants.BACK_APP_KEY, Constants.BACK_APP_SECRET);

	/**
	 * @Description: 获取卖家信息，必要授权
	 */
	public User getSellerUser(String sessionKey) throws MyException {
		UserSellerGetRequest req = new UserSellerGetRequest();
		req.setFields("user_id,nick,seller_credit");
		UserSellerGetResponse response = null;
		try {
			response = client.execute(req, sessionKey);
			return response.getUser();
		} catch (Exception e) {
			throw new MyException("获取卖家信息失败:" + response.getBody(), e);
		}
	}

	/**
	 * @Description: 获取普通买家信息，非必要授权
	 */
	public User getUser(String sessionKey) throws MyException {
		UserGetRequest req = new UserGetRequest();
		req.setFields("nick,sex");
		UserGetResponse response = null;
		try {
			response = client.execute(req, sessionKey);
			return response.getUser();
		} catch (Exception e) {
			throw new MyException("获取买家信息失败:" + response.getBody(), e);
		}
	}

	/**
	 * @Description 获取用户丢弃了消息 不需要授权
	 */
	public List<DiscardInfo> discardinfo() throws MyException {
		CometDiscardinfoGetRequest req = new CometDiscardinfoGetRequest();
		long nCurrentTime = System.currentTimeMillis();
		CometDiscardinfoGetResponse response = null;
		try {
			req.setStart(new Date(nCurrentTime - 1000 * 60 * 55));
			response = client.execute(req);
			List<DiscardInfo> discardInfos = response.getDiscardInfoList();
			return discardInfos;
		} catch (Exception e) {
			throw new MyException("获取用户丢弃了消息失败:" + response.getBody(), e);
		}

	}

	/**
	 * @Description: 获取交易变更通知信息 不需呀授权
	 */
	public List<NotifyTrade> getIncrementTrades(String nick) throws MyException {
		IncrementTradesGetRequest req = new IncrementTradesGetRequest();
		req.setNick(nick);
		req.setStatus("TradeSuccess");
		req.setPageNo(1L);
		req.setPageSize(40L);
		IncrementTradesGetResponse response = null;
		try {
			response = client.execute(req);
			List<NotifyTrade> trades = response.getNotifyTrades();
			return trades;
		} catch (Exception e) {
			throw new MyException("获取交易变更通知信息失败:" + response.getBody(), e);
		}
	}

	/**
	 * @Description: 开通授权主动通知业务 需要授权session
	 */
	public boolean beginPermit(String session) throws MyException {
		IncrementCustomerPermitRequest permitReq = new IncrementCustomerPermitRequest();
		/**
		 * 指定类型，get表示此appkey可以主动通过调用taobao.increment.items.get等api获取数据，
		 * notify表示此appkey可以通过主动推送的方式接收消息
		 */
		permitReq.setType("get,notify");
		// 以下的topics和status根据自己业务所需的业务类型的消息，传入合适的值，可参考api文档。
		/**
		 * 指定只接收此用户的那些类型的消息，虽然在开通app的订阅消息关系的时候指定了app接收那些类型的数据，
		 * 但是在调用taobao.increment.customer.permit接口的时候可以指定对不同的用户接收不同类型的消息
		 * 比如：app订阅的时候指定了接收，交易，退款，商品的消息， 但是调用此接口可以指定只接收A用户的交易消息，只接收B用户的退款消息，
		 * 如果这里没有指定的话则默认接收的消息类型和app开通时指定的消息类型是一致的
		 */
		permitReq.setTopics("trade;item");
		/**
		 * status的说明同上面的topic
		 */
		permitReq.setStatus("TradeSuccess;ItemUpdate");
		IncrementCustomerPermitResponse permitResp = null;
		try {
			permitResp = client.execute(permitReq, session);
			// 有两个返回值valid_session和invalid_session。valid_session表示已开通且seesion有效；invalid_session已开通但session失效，此时，无法接收该用户的消息。
			if (permitResp != null) {
				if (permitResp.getAppCustomer().getStatus().equals("valid_session"))
					return true;
			}
			return false;
		} catch (Exception e) {
			throw new MyException("开通授权主动通知业务失败" + permitResp.getBody(), e);
		}
	}

	/**
	 * @Description: 关闭主动通知业务 无需授权
	 */
	public boolean clostPermit(String username) throws MyException {
		IncrementCustomerStopRequest req = new IncrementCustomerStopRequest();
		req.setNick(username);
		req.setType("get,notify,syn");
		IncrementCustomerStopResponse response = null;
		try {
			response = client.execute(req);
			return response.getIsSuccess();
		} catch (Exception e) {
			throw new MyException("关闭主动授权失败" + response.getBody(), e);
		}
	}

	/**
	 * @Description: 获取异步交易任务ID 需要授权
	 */
	public Long getSoldTaskId(String session) throws MyException {
		TopatsTradesSoldGetRequest req = new TopatsTradesSoldGetRequest();
		req.setFields("tid,seller_nick,buyer_nick,title,payment,parent_id,type,status,created,orders");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -3);
		req.setStartTime(Constants.df2.format(calendar.getTime()));// 三个月前
		calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		req.setEndTime(Constants.df2.format(calendar.getTime()));// 前一天
		TopatsTradesSoldGetResponse response = null;
		try {
			response = client.execute(req, session);
			return response.getTask().getTaskId();
		} catch (Exception e) {
			throw new MyException("获取异步任务ID失败:" + response.getBody(), e);
		}
	}

	public static void main(String[] args) throws MyException {
		System.out.println(new TopApi().getSoldTaskId(""));
	}
}
