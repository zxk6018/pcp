package com.hz.pojo;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.hibernate.annotations.Entity;
import javax.persistence.*;

@Entity
@Table(name = "goods")
@Data
public class Goods implements Serializable{

	private static final long serialVersionUID =  2790411100461909424L;

	/**
	 * 商品ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@TableId(type = IdType.AUTO)
	@Column(name = "goods_id")
	private int goodsId;

	/**
	 * 类型ID
	 */
	@Column(name = "goods_type_id")
	private int goodsTypeId;

	/**
	 * 商品名称
	 */
	@Column(name = "goods_name")
	private String goodsName;

	/**
	 * 商品标题
	 */
	@Column(name = "goods_title")
	private String goodsTitle;

	/**
	 * 创建时间
	 */
	@Column(name = "goods_creatime")
	private String goodsCreatime;

	/**
	 * 销量
	 */
	@Column(name = "goods_sales")
	private int goodsSales;

	/**
	 * 创建人ID
	 */
	@Column(name = "goods_admin_id")
	private int goodsAdminId;

	/**
	 * 是否推荐(0不推荐   1推荐   默认0)
	 */
	@Column(name = "goods_recommend")
	private int goodsRecommend;

	/**
	 * 状态(0待上架  1已上架  2下架)
	 */
	@Column(name = "goods_state")
	private int goodsState;

}
