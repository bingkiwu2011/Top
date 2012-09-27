package com.top.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Description: mvc导航
 */

@Controller
public class ComonController {
	
	@RequestMapping("/index")
	public String index() {
		//return "redirect:/index";
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/customer")
	public String customer() {
		return "customer/customer";
	}
	
	@RequestMapping("/seller")
	public String seller() {
		return "seller/seller";
	}
}