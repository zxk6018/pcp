package com.hz.pojo;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.hibernate.annotations.Entity;
import javax.persistence.*;

@Entity
@Table(name = "size")
@Data
public class Size implements Serializable{

	private static final long serialVersionUID =  5851580658077339981L;

	/**
	 * 规格ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@TableId(type = IdType.AUTO)
	@Column(name = "size_id")
	private int sizeId;

	/**
	 * 规格名称
	 */
	@Column(name = "size_name")
	private String sizeName;

	/**
	 * 库存
	 */
	@Column(name = "size_inventory")
	private int sizeInventory;

	/**
	 * 价格
	 */
	@Column(name = "size_price")
	private double sizePrice;

	/**
	 * 是否推荐(0否 1是)
	 */
	@Column(name = "size_recommend")
	private int sizeRecommend;

	/**
	 * 状态(0待上架  1已上架  2下架)
	 */
	@Column(name = "size_state")
	private int sizeState;

}
