package com.top.test;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;  
import java.util.List;  
  
import com.alibaba.fastjson.JSON;  
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;  
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.taobao.api.domain.Order;
import com.taobao.api.domain.Trade;
  
  
public class TestFastJson {    
    public static void main(String[] args) {    
    	Color color = Color.RED; 
    	String text = JSON.toJSONString(color, SerializerFeature.WriteClassName); 
    	System.out.println(text); 
    	Color color2 = (Color) JSON.parse(text); 
    	System.out.println(color2.getRed());
    	
    	Trade t=new Trade();
    	t.setBuyerNick("tom");
    	Order order=new Order();
    	order.setCid(3333l);
    	List<Order>orders=new ArrayList<Order>();
    	orders.add(order);
    	
    	t.setOrders(orders);
    	String string=JSON.toJSONString(t);
    	System.out.println(string);
    	//Trade trade=JSON.parseArray(string,Trade.class);
		
		
		//System.out.println(trade.getBuyerNick());
    }    
}    
  
 