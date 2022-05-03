package com.hz.pojo;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.hibernate.annotations.Entity;
import javax.persistence.*;

@Entity
@Table(name = "pettype")
@Data
public class Pettype implements Serializable{

	private static final long serialVersionUID =  5194240721311240794L;

	/**
	 * 类型ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@TableId(type = IdType.AUTO)
	@Column(name = "pettype_id")
	private int pettypeId;

	/**
	 * 类型名称
	 */
	@Column(name = "pettype_name")
	private String pettypeName;

}
