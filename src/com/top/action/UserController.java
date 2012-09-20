package com.top.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.top.model.jpa.Users;
import com.top.service.IUsersService;

/*可以通过redirect/forward:url方式转到另一个Action进行连续的处理。
 可以通过redirect:url 防止表单重复提交 。
 写法如下：
 return "forward:/order/add";
 return "redirect:/index.jsp";*/

@Controller
public class UserController {
	@Resource
	IUsersService usersService;

	@RequestMapping(params = "method=add")
	public String login(@ModelAttribute("user") Users user, HttpServletRequest req, HttpServletResponse response) {
		// 此处调用服务层进行相应的业务操作
		System.out.println("用户信息: " + user);
		// 传递对象于下一页面
		req.setAttribute("user", user);
		// 调用服务层进行验证用户,此处只演示功能
		if ("spring".equals(user.getUsername()) && "spring".equals(user.getPassword())) {
			System.out.println("用户信息2222: " + user);
			return "/page/succ";
		}

		return "/page/error";
	}

	// json
	@RequestMapping("newsellers")
	@ResponseBody
	public List<Users> newsellers() {
		List<Users> users = new ArrayList<Users>();
		List<Users> users2 = usersService.findTop10Sellers();
		Users u;
		for(Users uu:users2){
			u=new Users();
			u.setUsername(uu.getUsername());
			u.setLevel(uu.getLevel());
			users.add(u);
		}
		return users;

	}

	// @RequestMapping(params= "method=add2",method=RequestMethod.POST)
	// 定义method方法不是必须的
	@RequestMapping(params = "method=add2")
	public ModelAndView login2(@ModelAttribute("user") Users user, HttpServletRequest req, HttpServletResponse response) {

		// 此处调用服务层进行相应的业务操作
		System.out.println("用户信息2: " + user);
		// 使用ModelAndView保存对象于下一页面
		ModelAndView model = new ModelAndView();
		model.addObject("user", user);

		// 调用服务层进行验证用户,此处只演示功能
		if ("spring".equals(user.getUsername()) && "spring".equals(user.getPassword())) {
			model.setViewName("/page/succ");
		} else {
			model.setViewName("/page/error");
		}
		return model;
	}

	@RequestMapping(params = "method=add3")
	public String login3(@ModelAttribute("user") Users user, Model model) {

		model.addAttribute("user", user);
		System.out.println("用户信息3: " + user);
		// 调用服务层进行验证用户,此处只演示功能
		if ("spring".equals(user.getUsername()) && "spring".equals(user.getPassword())) {
			return "/page/succ";
		}
		// 放入model默认把参数存于请求
		model.addAttribute("msg", "用户或者密码错误!");
		return "/page/error";

		/**
		 * 重定向JSP页面,走出了springmvc配置的view(jsp)
		 * 因为这样说明:model.addAttribute("msg","用户或者密码错误!"); 获取不到值了
		 * 不加上.jsp就是这样:http:
		 * //127.0.0.1:8080/Spring3-Login-Annotaction/index?msg=%E7...
		 * */
		// 返回到页面是乱码在页面中用${msg}获取不到值,用request.getParams("msg");为乱码
		// return "redirect:index.jsp?msg=用户或者密码错误!";
	}
}