package com.top.action;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.top.exception.MyException;
import com.top.model.jpa.Trade;
import com.top.security.UserInfo;
import com.top.security.SecurityUtil;
import com.top.service.ICustomerService;
import com.top.service.ITradeService;

@Controller
//@RolesAllowed({ "ROLE_SELLER" })
public class TradeController {
	@Resource
	private ITradeService tradeService;
	@SuppressWarnings("unused")
	@Resource
	private ICustomerService customerService;

	@RequestMapping("/tradetest")
	public String index() {
		try {
			System.out.println(tradeService);
			List<Trade> trades = tradeService.getTradesBySellerNick("bingki");
			if (trades != null)
				System.out.println(trades.size());
			List<Trade> trades2 = tradeService.getTradesBySellerNick("bingki");
			if (trades2 != null)
				System.out.println(trades2.size());
			/*
			 * Customer customer=new Customer(); customer.setName("bingki");
			 * customer.setIntegral(111d);
			 * System.out.println("id:"+customerService
			 * .saveOrUpdateCustomer(customer).getId());
			 * 
			 * customer.setIntegral(customer.getIntegral()+1);
			 * System.out.println
			 * ("id:"+customerService.saveOrUpdateCustomer(customer).getId());
			 * 
			 * 
			 * Users user=new Users(); user.setIclass(0.05); Trade trade=new
			 * Trade(); trade.setBuyerNick("bingki2"); trade.setModified("111");
			 * trade.setPayment(109.6); trade.setSellerNick("tom");
			 * trade.setStatus(""); trade.setTid(1l);
			 * tradeService.addTrade(trade, user);
			 */

			UserInfo userDetails = SecurityUtil.getUser();
			System.out.println("111"+userDetails.getUsername());
		} catch (MyException e) {
			e.printStackTrace();
		}

		return "index";
	}

}