package com.hz.pojo;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.hibernate.annotations.Entity;
import javax.persistence.*;

@Entity
@Table(name = "pethelp")
@Data
public class Pethelp implements Serializable{

	private static final long serialVersionUID =  8462421329343078789L;

	/**
	 * 救助队ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@TableId(type = IdType.AUTO)
	@Column(name = "pethelp_id")
	private int pethelpId;

	/**
	 * 救助队名
	 */
	@Column(name = "pethelp_name")
	private String pethelpName;

	/**
	 * 用户ID（组织者）
	 */
	@Column(name = "pethelp_user_id")
	private int pethelpUserId;

	/**
	 * 队标（图片）
	 */
	@Column(name = "pethelp_img")
	private String pethelpImg;

	/**
	 * 电话（联系救助电话）
	 */
	@Column(name = "pethelp_user_phone")
	private String pethelpUserPhone;

	/**
	 * 救助地区（例：郑州市，洛阳市）
	 */
	@Column(name = "pethelp_address")
	private String pethelpAddress;

	/**
	 * 证件编号
	 */
	@Column(name = "pethelp_papers_num")
	private String pethelpPapersNum;

	/**
	 * 证件图片
	 */
	@Column(name = "pethelp_papers_img")
	private String pethelpPapersImg;

	/**
	 * 救助站地址
	 */
	@Column(name = "pethelp_home_address")
	private String pethelpHomeAddress;

	/**
	 * 审核状态（0待审核 1正常 2异常  3驳回）
	 */
	@Column(name = "pethelp_state")
	private int pethelpState;

	/**
	 * 处理人ID（管理员ID）
	 */
	@Column(name = "pethelp_admin_id")
	private int pethelpAdminId;

	/**
	 * 处理意见
	 */
	@Column(name = "pethelp_opinion")
	private String pethelpOpinion;

	/**
	 * 处理时间
	 */
	@Column(name = "pethelp_disposetime")
	private String pethelpDisposetime;

	/**
	 * 用户
	 */
	private User user;
}
