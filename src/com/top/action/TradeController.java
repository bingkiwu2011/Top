package com.top.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.top.exception.MyException;
import com.top.model.jpa.Customer;
import com.top.model.jpa.Trade;
import com.top.model.jpa.Users;
import com.top.service.ICustomerService;
import com.top.service.ITradeService;


@Controller
public class TradeController {
	@Resource
	private ITradeService tradeService;
	@Resource
	private ICustomerService customerService;
	
	@RequestMapping("/tradetest")
	public String index() {
		try {
		
			
			
			Users user=new Users();
			user.setIclass(0.05);
			Trade trade=new Trade();
			trade.setBuyerNick("bingki2");
			trade.setModified("111");
			trade.setPayment(109.6);
			trade.setSellerNick("tom");
			trade.setStatus("");
			trade.setTid(1l);
			tradeService.addTrade(trade, user);
		} catch (MyException e) {
			e.printStackTrace();
		}
		
		return "index";
	}
	
}