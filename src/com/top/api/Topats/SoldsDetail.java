/** 
 * @Title: SoldsDetail.java 
 * @Package com.top.test 
 * @Description: TODO(用一句话描述该文件做什么) 
 * Copyright: Copyright (c)2009 
 * Company:上海建周 
 * @author bingki 
 * @date 2012-8-27 下午6:25:49 
 *@version 1.0 
 */
package com.top.api.Topats;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSON;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.Order;
import com.taobao.api.domain.Task;
import com.taobao.api.internal.util.AtsUtils;
import com.taobao.api.request.TopatsResultGetRequest;
import com.taobao.api.response.TopatsResultGetResponse;
import com.top.api.service.TopApi;
import com.top.common.Constants;
import com.top.exception.MyException;

/**
 * @ClassName: SoldsDetail
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author bingki
 * @date 2012-8-27 下午6:25:49
 */
public class SoldsDetail {
	private TaobaoClient client = new DefaultTaobaoClient(Constants.URL, Constants.BACK_APP_KEY, Constants.BACK_APP_SECRET);
	//private static Log log = LogFactory.getLog(SoldsDetail.class);

	// 获取任务ID
	public Long getSoldTaskId(String session) throws MyException {
		TopApi topApi = new TopApi();
		return topApi.getSoldTaskId(session);
	}

	public void getTaskResult(Long taskId) throws MyException {
		TopatsResultGetRequest req3 = new TopatsResultGetRequest();
		req3.setTaskId(taskId);
		TopatsResultGetResponse rsp;
		try {
			rsp = client.execute(req3);
			if (rsp.isSuccess() && rsp.getTask().getStatus().equals("done")) {
				Task task = rsp.getTask();
				String url = task.getDownloadUrl();
				File taskFile = AtsUtils.download(url, new File(Constants.topats_downdir)); // 下载文件到本地
				File resultFile = new File(Constants.topats_unzipdir); // 解压后的结果文件夹
				List<File> files = AtsUtils.unzip(taskFile, resultFile); // 解压缩并写入到指定的文件夹
				// 遍历解压到的文件列表并读取结果文件进行解释
				readFile(files);
			}
		} catch (Exception e) {
			throw new MyException("error getTaskResult", e);
		}
	}

	// 遍历解压到的文件列表并读取结果文件进行解释
	public void readFile(List<File> files) throws MyException {
		try {
			for (File file : files) {
				List<String> lines = FileUtils.readLines(file, "UTF-8");
				String str = "";
				String tradeJson = "";
				String ordersJson = "";
				String order = "";
				for (String string : lines) {
					str = JSON.parseObject(string).getString("trade_fullinfo_get_response");
					tradeJson = JSON.parseObject(str).getString("trade");
					ordersJson = JSON.parseObject(tradeJson).getString("orders");
					order = JSON.parseObject(ordersJson).getString("order");
					List<Order> orders = JSON.parseArray(order, Order.class);

					// 处理交易详情信息
					System.out.println(orders.get(0).getCid());
				}
			}

		} catch (IOException e) {
			throw new MyException("error readFile", e);
		}
	}

	public static void main(String[] args) throws MyException, IOException {

		SoldsDetail soldsDetail = new SoldsDetail();

		soldsDetail.getSoldTaskId("6101c05d310e41402afdf6c746b1f96f2fa5228aa07183920500435");
	}
}
