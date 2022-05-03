package com.hz.pojo;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.hibernate.annotations.Entity;
import javax.persistence.*;

@Entity
@Table(name = "commodity")
@Data
public class Commodity implements Serializable{

	private static final long serialVersionUID =  3506036911616264964L;

	/**
	 * 图片ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@TableId(type = IdType.AUTO)
	@Column(name = "commodity_id")
	private int commodityId;

	/**
	 * 图片路径
	 */
	@Column(name = "commodity_img")
	private String commodityImg;

	/**
	 * 所属商品ID
	 */
	@Column(name = "commodity_product_id")
	private int commodityProductId;

	/**
	 * 是否封面(0否  1是)
	 */
	@Column(name = "commodity_recommend")
	private int commodityRecommend;

}
