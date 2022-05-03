package com.hz.pojo;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.hibernate.annotations.Entity;
import javax.persistence.*;

@Entity
@Table(name = "comments")
@Data
public class Comments implements Serializable{

	private static final long serialVersionUID =  4291878292250737398L;

	/**
	 * 评论ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@TableId(type = IdType.AUTO)
	@Column(name = "comments_id")
	private int commentsId;

	/**
	 * 评论内容
	 */
	@Column(name = "comments_text")
	private String commentsText;

	/**
	 * 评论人ID
	 */
	@Column(name = "comments_user_id")
	private int commentsUserId;

	/**
	 * 文章ID
	 */
	@Column(name = "comments_essay_id")
	private int commentsEssayId;

	/**
	 * 评论时间
	 */
	@Column(name = "comments_time")
	private String commentsTime;

	/**
	 * 点赞数
	 */
	@Column(name = "comments_count")
	private int commentsCount;

	/**
	 * 回复人ID
	 */
	@Column(name = "comments_byuser")
	private int commentsByuser;

	/**
	 * 回复评论ID
	 */
	@Column(name = "comments_bytext")
	private int commentsBytext;

}
