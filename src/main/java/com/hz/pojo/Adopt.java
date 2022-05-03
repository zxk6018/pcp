package com.hz.pojo;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.hibernate.annotations.Entity;
import javax.persistence.*;

@Entity
@Table(name = "adopt")
@Data
public class Adopt implements Serializable{

	private static final long serialVersionUID =  4098094254310551340L;

	/**
	 * 领养发布ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@TableId(type = IdType.AUTO)
	@Column(name = "adopt_id")
	private int adoptId;

	/**
	 * 用户ID
	 */
	@Column(name = "adopt_user_id")
	private int adoptUserId;

	/**
	 * 类型（0领养  1寄养 3征婚交友）
	 */
	@Column(name = "adopt_type")
	private int adoptType;

	/**
	 * 发布信息（请输入宠物基本信息，领养要求，上传宠物照片）
	 */
	@Column(name = "adopt_message")
	private String adoptMessage;

	/**
	 * 发布时间
	 */
	@Column(name = "adopt_time")
	private String adoptTime;

	/**
	 * 是否是救助站（0否 1是）
	 */
	@Column(name = "adopt_pethelps")
	private int adoptPethelps;

	/**
	 * 审核状态（0待审核 1审核通过 2审核失败  3关闭）
	 */
	@Column(name = "adopt_review")
	private int adoptReview;

	/**
	 * 逻辑删除（（0否   1是））
	 */
	@Column(name = "adopt_del")
	private int adoptDel;

	/**
	 * 审核人ID（管理员ID）
	 */
	@Column(name = "adopt_admin_id")
	private int adoptAdminId;

	/**
	 * 审核时间
	 */
	@Column(name = "adopt_disposetime")
	private String adoptDisposetime;

}
