package com.hz.pojo;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.hibernate.annotations.Entity;
import javax.persistence.*;

@Entity
@Table(name = "order")
@Data
public class Order implements Serializable{

	private static final long serialVersionUID =  5056161864477231280L;

	/**
	 * 订单ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@TableId(type = IdType.AUTO)
	@Column(name = "order_id")
	private int orderId;

	/**
	 * 订单编号
	 */
	@Column(name = "order_number")
	private String orderNumber;

	/**
	 * 付款时间
	 */
	@Column(name = "order_pay_time")
	private String orderPayTime;

	/**
	 * 购买时间
	 */
	@Column(name = "order_pur_time")
	private String orderPurTime;

	/**
	 * 购买人ID(用户ID)
	 */
	@Column(name = "order_user_id")
	private int orderUserId;

	/**
	 * 订单金额
	 */
	@Column(name = "order_amount")
	private double orderAmount;

	/**
	 * 优惠金额
	 */
	@Column(name = "order_pre_a")
	private double orderPreA;

	/**
	 * 收货地址
	 */
	@Column(name = "order_address_id")
	private String orderAddressId;

	/**
	 * 实付金额
	 */
	@Column(name = "order_paid_amount")
	private double orderPaidAmount;

	/**
	 * 订单状态(0待支付  1待发货  2待收货  3待评价 4退款售后)
	 */
	@Column(name = "order_state")
	private int orderState;

}
