package com.hz.pojo;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.hibernate.annotations.Entity;
import javax.persistence.*;

@Entity
@Table(name = "func")
@Data
public class Func implements Serializable{

	private static final long serialVersionUID =  310425262176657369L;

	/**
	 * 功能ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@TableId(type = IdType.AUTO)
	@Column(name = "func_id")
	private int funcId;

	/**
	 * 菜单ID(外键（权限表/菜单表 ID）)
	 */
	@Column(name = "func_system_id")
	private int funcSystemId;

	/**
	 * 功能名称
	 */
	@Column(name = "func_name")
	private String funcName;

	/**
	 * 功能标识
	 */
	@Column(name = "func_ico")
	private String funcIco;

}
