package com.hz.pojo;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.hibernate.annotations.Entity;
import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class User implements Serializable{

	private static final long serialVersionUID =  2321622675835499321L;

	/**
	 * 用户ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@TableId(type = IdType.AUTO)
	@Column(name = "user_id")
	private int userId;

	/**
	 * 用户名
	 */
	@Column(name = "user_name")
	private String userName;

	/**
	 * 用户密码
	 */
	@Column(name = "user_password")
	private String userPassword;

	/**
	 * 性别(0女 1男)
	 */
	@Column(name = "user_sex")
	private int userSex;

	/**
	 * 年龄
	 */
	@Column(name = "user_age")
	private int userAge;

	/**
	 * 电话
	 */
	@Column(name = "user_phone")
	private String userPhone;

	/**
	 * 地址(省/市/区)
	 */
	@Column(name = "user_address")
	private String userAddress;

	/**
	 * 是否实名认证(0否 1是)
	 */
	@Column(name = "user_autonym")
	private int userAutonym;

	/**
	 * 身份证号码
	 */
	@Column(name = "user_idcard")
	private String userIdcard;

	/**
	 * 头像
	 */
	@Column(name = "user_head")
	private String userHead;

	/**
	 * 其他认证(救助队/寄养家庭认证)
	 */
	@Column(name = "user_approve")
	private String userApprove;

	/**
	 * 宠物(默认0只 无宠物)
	 */
	@Column(name = "user_pets")
	private int userPets;

	/**
	 * 评论（编号）（评论表获取ID）
	 */
	@Column(name = "user_comment")
	private int userComment;

	/**
	 * 注册时间
	 */
	@Column(name = "user_time")
	private String userTime;

	/**
	 * 用户状态
	 */
	@Column(name = "user_state")
	private int userState;

	/**
	 * 宠物
	 */
	private Pet pet;

	/**
	 * 宠物证书
	 */
	private Certificate certificate;
}
