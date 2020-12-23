package io.renren.modules.post_repay.entity;

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
 * @date 2020-12-22 18:53:24
 */
@Data
@TableName("post_reply")
public class PostReplyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer cid;
	/**
	 * 
	 */
	private String replytitle;
	/**
	 * 
	 */
	private String replycontent;
	/**
	 * 
	 */
	private String replyexpression;
	/**
	 * 
	 */
	private String replytime;
	/**
	 * 
	 */
	private Integer replyerid;
	/**
	 * 
	 */
	private Integer whichPostIdToReply;

}
