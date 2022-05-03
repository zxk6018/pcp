package com.hz.pojo;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.hibernate.annotations.Entity;
import javax.persistence.*;

@Entity
@Table(name = "config")
@Data
public class Config implements Serializable{

	private static final long serialVersionUID =  7942144137202991983L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@TableId(type = IdType.AUTO)
	@Column(name = "config_id")
	private int configId;

	/**
	 * 系统名称
	 */
	@Column(name = "config_name")
	private String configName;

	/**
	 * 域名
	 */
	@Column(name = "config_domain")
	private String configDomain;

	/**
	 * APPid
	 */
	@Column(name = "config_appid")
	private String configAppid;

	/**
	 * 短信账号
	 */
	@Column(name = "config_account")
	private String configAccount;

	/**
	 * 短信密码
	 */
	@Column(name = "config_password")
	private String configPassword;

	/**
	 * 备案号
	 */
	@Column(name = "config_icp")
	private String configIcp;

}
