package com.hz.pojo;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.hibernate.annotations.Entity;
import javax.persistence.*;

@Entity
@Table(name = "autho")
@Data
public class Autho implements Serializable{

	private static final long serialVersionUID =  7158081640083743930L;

	/**
	 * 管理员ID
	 */
	@Column(name = "auhto_admin_id")
	private int auhtoAdminId;

	/**
	 * 权限ID
	 */
	@Column(name = "autho_system_id")
	private int authoSystemId;

	/**
	 * 权限名
	 */
	@Column(name = "autho_system_name")
	private String authoSystemName;

}
