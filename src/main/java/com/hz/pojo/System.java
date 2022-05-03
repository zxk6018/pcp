package com.hz.pojo;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.hibernate.annotations.Entity;
import javax.persistence.*;

@Entity
@Table(name = "system")
@Data
public class System implements Serializable{

	private static final long serialVersionUID =  4113955571904911368L;

	/**
	 * 权限ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@TableId(type = IdType.AUTO)
	@Column(name = "system_id")
	private int systemId;

	/**
	 * 权限名称
	 */
	@Column(name = "system_name")
	private String systemName;

	/**
	 * 图标
	 */
	@Column(name = "system_ico")
	private String systemIco;

	/**
	 * URL（权限路径）
	 */
	@Column(name = "system_url")
	private String systemUrl;

	/**
	 * 父级ID（上级权限ID）
	 */
	@Column(name = "system_parent_id")
	private int systemParentId;

}
