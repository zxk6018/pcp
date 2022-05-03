package com.hz.pojo;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.hibernate.annotations.Entity;
import javax.persistence.*;

@Entity
@Table(name = "dou_area")
@Data
public class DouArea implements Serializable{

	private static final long serialVersionUID =  1161889731082131253L;

	@Column(name = "area_id")
	private Integer areaId;

	@Column(name = "parent_id")
	private Integer parentId;

	/**
	 * 城市名
	 */
	@Column(name = "name")
	private String name;

}
