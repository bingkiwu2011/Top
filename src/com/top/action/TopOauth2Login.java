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
import com.taobao.api.internal.util.WebUtils;
import com.top.common.Constants;
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
		if(req.getParameter("code")==null||req.getParameter("code").length()<=0){
			throw new MyException("TOP授权码异常!");
		}
		param.put("client_id", Constants.BACK_APP_KEY);
		param.put("client_secret", Constants.BACK_APP_SECRET);
		param.put("redirect_uri", Constants.redirectUrlPrefix);
		param.put("scope", "item");
		
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
				
				//model.addObject("salt", "hellobingki");//添加salt ，防止浏览器直接登录
				/*
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
		}
		//http://bingki.vicp.net:8081/Top/j_spring_security_check?j_password=unused&j_username=bingki
		//http://bingki.vicp.net:8081/Top/j_spring_security_check?j_password=1&j_username=amadeus
		model.setViewName("/common/error");
		return model;
	}
	
	
}
