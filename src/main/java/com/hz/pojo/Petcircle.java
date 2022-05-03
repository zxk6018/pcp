package com.hz.pojo;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.hibernate.annotations.Entity;
import javax.persistence.*;

@Entity
@Table(name = "petcircle")
@Data
public class Petcircle implements Serializable{

	private static final long serialVersionUID =  3346162075110126260L;

	/**
	 * 发布ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@TableId(type = IdType.AUTO)
	@Column(name = "petcircle_id")
	private int petcircleId;

	/**
	 * 用户ID
	 */
	@Column(name = "petcircle_user_id")
	private int petcircleUserId;

	/**
	 * 阅读量
	 */
	@Column(name = "petcircle_num")
	private int petcircleNum;

	/**
	 * 类型ID（宠物类型ID）
	 */
	@Column(name = "petcircle_pettype_id")
	private int petcirclePettypeId;

	/**
	 * 发布类型ID
	 */
	@Column(name = "petcircle_circletype_id")
	private int petcircleCircletypeId;

	/**
	 * 发布内容
	 */
	@Column(name = "petcircle_content")
	private String petcircleContent;

	/**
	 * 发布时间
	 */
	@Column(name = "petcircle_time")
	private String petcircleTime;

	/**
	 * 点赞数
	 */
	@Column(name = "petcircle_good")
	private int petcircleGood;

	/**
	 * 审核状态（0待审核 1审核通过 2审核失败 3删除）
	 */
	@Column(name = "petcircle_review")
	private int petcircleReview;

}
