package io.renren.modules.post.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * @date 2020-12-22 16:16:12
 */
@Data
@TableName("post")
public class PostEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private String content;
	/**
	 * 
	 */
	private String expression;
	/**
	 * 
	 */
	private String posttime;
	/**
	 * 
	 */
	private String postclass;
	/**
	 * 
	 */
	private Integer posterid;
	/**
	 * 
	 */
	private Integer postboardid;

	@TableField(exist = false)
	private String boardname;

	@TableField(exist = false)
	private String username;

}
