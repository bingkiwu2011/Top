package com.top.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/*可以通过redirect/forward:url方式转到另一个Action进行连续的处理。
 可以通过redirect:url 防止表单重复提交 。
 写法如下：
 return "forward:/order/add";
 return "redirect:/index.jsp";*/

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