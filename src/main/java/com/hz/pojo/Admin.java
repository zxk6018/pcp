package com.hz.pojo;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.hibernate.annotations.Entity;
import javax.persistence.*;

@Entity
@Table(name = "admin")
@Data
public class Admin implements Serializable{

	private static final long serialVersionUID =  6672220541506894566L;

	/**
	 * 管理员ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@TableId(type = IdType.AUTO)
	@Column(name = "admin_id")
	private int adminId;

	/**
	 * 管理员账号
	 */
	@Column(name = "admin_name")
	private String adminName;

	/**
	 * 管理员密码
	 */
	@Column(name = "admin_password")
	private String adminPassword;

	/**
	 * 管理员电话
	 */
	@Column(name = "admin_phone")
	private String adminPhone;

	/**
	 * 创建人ID
	 */
	@Column(name = "admin_role_autho_id")
	private int adminRoleAuthoId;

	/**
	 * 创建时间
	 */
	@Column(name = "admin_role_time")
	private String adminRoleTime;

	/**
	 * 权限ID
	 */
	@Column(name = "admin_autho_id")
	private int adminAuthoId;

	/**
	 * 权限名
	 */
	@Column(name = "admin_autho_name")
	private String adminAuthoName;

	/**
	 * 日志操作时间(开始时间)
	 */
	@Column(name = "admin_usertime")
	private String adminUsertime;

	/**
	 * 日志操作时间(结束时间)
	 */
	@Column(name = "admin_endtime")
	private String adminEndtime;

/*	*//**
	 * 角色
	 *//*
	private Role role;*/
}
