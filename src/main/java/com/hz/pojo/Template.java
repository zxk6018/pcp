package com.hz.pojo;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.hibernate.annotations.Entity;
import javax.persistence.*;

@Entity
@Table(name = "template")
@Data
public class Template implements Serializable{

	private static final long serialVersionUID =  3477804637741479140L;

	/**
	 * 模板ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@TableId(type = IdType.AUTO)
	@Column(name = "template_id")
	private int templateId;

	/**
	 * 模板名称
	 */
	@Column(name = "template_name")
	private String templateName;

	/**
	 * 模板内容(html)
	 */
	@Column(name = "template_content")
	private String templateContent;

	/**
	 * 模板描述
	 */
	@Column(name = "template_desc")
	private String templateDesc;

	/**
	 * 是否禁用(0禁用 1启用)
	 */
	@Column(name = "template_disa")
	private int templateDisa;

}
