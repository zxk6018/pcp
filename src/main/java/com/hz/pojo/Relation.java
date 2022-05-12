package com.hz.pojo;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.hibernate.annotations.Entity;
import javax.persistence.*;

@Entity
@Table(name = "relation")
@Data
public class Relation implements Serializable{

	private static final long serialVersionUID =  3461699562916417630L;

	/**
	 * 寄养联系信息ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@TableId(type = IdType.AUTO)
	@Column(name = "relation_id")
	private int relationId;

	/**
	 * 申请ID（用户ID）
	 */
	@Column(name = "relation_user_id")
	private int relationUserId;

	/**
	 * 申请理由
	 */
	@Column(name = "relation_reason")
	private String relationReason;

	/**
	 * 申请人电话
	 */
	@Column(name = "relation_phone")
	private String relationPhone;

	/**
	 * 领养发布ID
	 */
	@Column(name = "relation_adopt_id")
	private int relationAdoptId;

	/**
	 * 申请时间
	 */
	@Column(name = "relation_time")
	private String relationTime;

	/**
	 * user对象
	 */
	@Column(name = "user")
	private User user;
}
