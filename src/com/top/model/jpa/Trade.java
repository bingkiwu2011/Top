package com.top.model.jpa;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.taobao.api.TaobaoObject;

@Entity
@Table(name = "trade", catalog = "top")
public class Trade extends TaobaoObject {

	private static final long serialVersionUID = 8378333577157646774L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@Column(name = "buyer_nick", nullable = false, length = 50)
	private String buyerNick;

	/**
	 * 交易修改时间（格式：yyyy-MM-dd HH:mm:ss）
	 */
	@Column(name = "modified", nullable = false, length = 20)
	private String modified;

	/**
	 * 买家实付金额
	 */
	@Column(name = "payment", nullable = false, precision = 10)
	private Double payment;

	/**
	 * 卖家昵称
	 */
	@Column(name = "seller_nick", nullable = false, length = 50)
	private String sellerNick;

	/**
	 * 交易操作所对应的交易增量消息状态，对应与NotifyTrade的status字段
	 * 
	 * 可选值 TradeCreate（创建交易） TradeModifyFee（修改交易费用）
	 * TradeCloseAndModifyDetailOrder（关闭或修改子订单） TradeClose（关闭交易）
	 * TradeBuyerPay（买家付款） TradeSellerShip（卖家发货） TradeDelayConfirmPay（延长收货时间）
	 * TradePartlyRefund（子订单退款成功） TradePartlyConfirmPay（子订单打款成功）
	 * TradeSuccess（交易成功） TradeTimeoutRemind（交易超时提醒） TradeRated（交易评价变更）
	 * TradeMemoModified（交易备注修改） TradeLogisticsAddressChanged（修改交易收货地址）
	 * TradeChanged（修改订单信息（SKU等））
	 */
	@Column(name = "status", nullable = false, length = 30)
	private String status;

	/**
	 * 交易编号
	 */
	@Column(name = "tid", nullable = false)
	private Long tid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBuyerNick() {
		return buyerNick;
	}

	public String getModified() {
		return modified;
	}

	public Double getPayment() {
		return payment;
	}

	public String getSellerNick() {
		return sellerNick;
	}

	public String getStatus() {
		return status;
	}

	public Long getTid() {
		return tid;
	}

	public void setBuyerNick(String buyerNick) {
		this.buyerNick = buyerNick;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public void setPayment(Double payment) {
		this.payment = payment;
	}

	public void setSellerNick(String sellerNick) {
		this.sellerNick = sellerNick;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

}
