package io.renren.modules.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-12-22 18:53:06
 */
@Data
@TableName("user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer uid;
	/**
	 * 
	 */
	private String username;
	/**
	 * 
	 */
	private String upassword;
	/**
	 * 
	 */
	private String usex;
	/**
	 * 
	 */
	private String uaddress;
	/**
	 * 
	 */
	private String ubirthday;
	/**
	 * 
	 */
	private String unickname;
	/**
	 * 
	 */
	private String ustatus;
	/**
	 * 
	 */
	private Integer uscore;
	/**
	 * 
	 */
	private Date registTime;
	/**
	 * 
	 */
	private String lv;

}
