package com.hz.pojo;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.hibernate.annotations.Entity;
import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
public class Product implements Serializable{

	private static final long serialVersionUID =  2542308419024545458L;

	/**
	 * 商品类型ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@TableId(type = IdType.AUTO)
	@Column(name = "product_id")
	private int productId;

	/**
	 * 类型名称
	 */
	@Column(name = "product_name")
	private String productName;

	/**
	 * 类型图片
	 */
	@Column(name = "product_img")
	private String productImg;

	/**
	 * 父级ID
	 */
	@Column(name = "product_parent")
	private int productParent;

}
