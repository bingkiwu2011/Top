/** 
* @Title: Back.java 
* @Package com.top.action 
* @Description: TODO(用一句话描述该文件做什么) 
* Copyright: Copyright (c)2009 
* Company:上海建周 
* @author bingki 
* @date 2012-8-29 下午3:39:48 
*@version 1.0 
*/
package com.top.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.internal.util.WebUtils;
import com.taobao.api.request.IncrementCustomerPermitRequest;
import com.taobao.api.response.IncrementCustomerPermitResponse;
import com.top.common.Constants;
import com.top.dao.UsersDAO;
import com.top.exception.MyException;
import com.top.model.jpa.Users;
import com.top.service.IUsersService;
import com.top.util.ThreeDESCode;
import com.top.util.TopUtil;

/** 
 * @ClassName: 
 * @Description: TOP前后台登录
 * @author bingki 
 * @date 2012-8-29 下午3:39:48  
 */
@Controller
public class TopOauth2Login {
	private static Log log = LogFactory.getLog(TopOauth2Login.class);
	@Resource
	private IUsersService usersService;
	
	@RequestMapping("/front")
	public ModelAndView loginFront(HttpServletRequest req, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		if (req.getParameter("top_appkey") != null) {
			try {
				System.out.println("seller:"+req.getParameter("seller_nick"));
				System.out.println("visit:"+TopUtil.ParametersName(req.getParameter("top_parameters")));
				model.addObject("visit", TopUtil.ParametersName(req.getParameter("top_parameters")));
				model.setViewName("front");
				return model;
			} catch (Exception e) {
				log.error("error front login",e);
				e.printStackTrace();
			}
		}
		model.setViewName("/common/error");
		return model;
		
	}
	
	@RequestMapping("/back")
	public ModelAndView loginBack(HttpServletRequest req, HttpServletResponse response) throws MyException {
		ModelAndView model = new ModelAndView();
		Map<String, String> param = new HashMap<String, String>();
		param.put("grant_type", "authorization_code");
		param.put("code",req.getParameter("code"));
		param.put("client_id", Constants.BACK_APP_KEY);
		param.put("client_secret", Constants.BACK_APP_SECRET);
		param.put("redirect_uri", Constants.redirectUrlPrefix);
		param.put("scope", "item");
		if(req.getParameter("code")==null||req.getParameter("code").length()<=0){
			throw new MyException("error authorize code!");
		}
		String responseJson="";
		try {
			responseJson = WebUtils.doPost("https://oauth.taobao.com/token", param, 3000, 3000);
			//System.out.println(responseJson);
			JSONObject jsonObject=JSON.parseObject(responseJson);
			if (jsonObject.getString("access_token").length() > 0) {
				req.getSession().setAttribute(Constants.SESSION_USERS, jsonObject.getString("taobao_user_nick"));
				req.getSession().setAttribute(Constants.SESSION_TOKEN, jsonObject.getString("access_token"));
				Users user=usersService.findByUsername(jsonObject.getString("taobao_user_nick"));
				if(user==null){
					//如果空，即表示之前没有登录过，需要添加用户
					user =new Users();
					user.setUsername(jsonObject.getString("taobao_user_nick"));
					usersService.addUsers(jsonObject.getString("access_token"));
				}
				model.addObject("j_username", user.getUsername());
				model.addObject("j_password", ThreeDESCode.encryptThreeDESECB(user.getUsername()));
				/*model.addObject("salt", "hellobingki");//添加salt ，防止浏览器直接登录
				if (permit(Constants.BACK_APP_KEY, Constants.BACK_APP_SECRET, jsonObject.getString("access_token"))) {
					System.out.println("主动通知业务授权成功!");

					System.out.println("开始接受通知!");
				} else {
					System.out.println("主动通知业务授权失败!");
				}*/
			}
			
			model.setViewName("rediretlogin");
			return model;
		} catch (Exception e1) {
			log.error(e1);
			e1.printStackTrace();
		}
		//http://bingki.vicp.net:8081/Top/j_spring_security_check?j_password=unused&j_username=bingki
		//http://bingki.vicp.net:8081/Top/j_spring_security_check?j_password=1&j_username=amadeus
		model.setViewName("/common/error");
		return model;
	}
	
	// 授权主动通知业务
		private boolean permit(String appKey, String secret, String session) {
			TaobaoClient client = new DefaultTaobaoClient(Constants.URL, appKey, secret);
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
			try {
				IncrementCustomerPermitResponse permitResp = client.execute(permitReq, session);
				System.out.println(permitResp);
				// 有两个返回值valid_session和invalid_session。valid_session表示已开通且seesion有效；invalid_session已开通但session失效，此时，无法接收该用户的消息。
				if (permitResp != null) {
					System.out.println(permitResp.isSuccess());
					if (permitResp.getAppCustomer().getStatus().equals("valid_session"))
						return true;
				}
				return false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
}
