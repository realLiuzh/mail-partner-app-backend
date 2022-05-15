package com.cqupt.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author lzh
 * @email 1138423425@qq.com
 * @date 2022-05-15 20:08:07
 */
@Data
@TableName("tb_comments")
public class CommentsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer userId;
	/**
	 * 
	 */
	private Integer postId;
	/**
	 * 
	 */
	private Integer parentId;
	/**
	 * 
	 */
	private Integer likeNumber;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Integer isValid;

}
