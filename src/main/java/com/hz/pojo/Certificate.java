package com.hz.pojo;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.hibernate.annotations.Entity;
import javax.persistence.*;

@Entity
@Table(name = "certificate")
@Data
public class Certificate implements Serializable{

	private static final long serialVersionUID =  6321663258016161675L;

	/**
	 * 证书ID
	 */
	@Column(name = "cert_id")
	private int certId;

	/**
	 * 证书路径（图片）
	 */
	@Column(name = "cert_url")
	private String certUrl;

	/**
	 * 证书描述
	 */
	@Column(name = "cert_desc")
	private String certDesc;

	/**
	 * 宠物ID
	 */
	@Column(name = "cert_pet_id")
	private int certPetId;

}
