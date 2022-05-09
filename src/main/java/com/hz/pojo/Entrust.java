package com.hz.pojo;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.hibernate.annotations.Entity;
import javax.persistence.*;

@Entity
@Table(name = "entrust")
@Data
public class Entrust implements Serializable{

	private static final long serialVersionUID =  6443588150255992408L;

	/**
	 * 寄养ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@TableId(type = IdType.AUTO)
	@Column(name = "entrust_id")
	private int entrustId;

	@Column(name = "entrust_user_id")
	private int entrustUserId;

	/**
	 * 真实姓名
	 */
	@Column(name = "entrust_rname")
	private String entrustRname;

	/**
	 * 身份证号
	 */
	@Column(name = "entrust_user_idcard")
	private String entrustUserIdcard;

	/**
	 * 申请信息
	 */
	@Column(name = "entrust_message")
	private String entrustMessage;

	/**
	 * 申请时间
	 */
	@Column(name = "entrust_time")
	private String entrustTime;

	/**
	 * 审核状态（0待审核 1审核通过 2审核失败  3关闭）
	 */
	@Column(name = "entrust_review")
	private int entrustReview;

	/**
	 * 家庭环境描述
	 */
	@Column(name = "entrust_envir")
	private String entrustEnvir;

	/**
	 * 地区ID
	 */
	@Column(name = "entrust_address_id")
	private int entrustAddressId;

	/**
	 * 详细地址
	 */
	@Column(name = "entrust_address")
	private String entrustAddress;

	/**
	 * 逻辑删除（0否 1是）
	 */
	@Column(name = "entrust_del")
	private int entrustDel;

	/**
	 * 处理人ID
	 */
	@Column(name = "entrust_admin_id")
	private int entrustAdminId;

	/**
	 * 处理时间
	 */
	@Column(name = "entrust_disposetime")
	private String entrustDisposetime;

	/**
	 * user对象
	 */
	@Column(name = "user")
	private User user;
}
