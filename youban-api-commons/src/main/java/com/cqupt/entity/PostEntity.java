package com.cqupt.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
@TableName("tb_post")
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
	private Date createTime;
	/**
	 * 
	 */
	private Date updateTime;
	/**
	 * 
	 */
	private Integer isValid;
	/**
	 * 
	 */
	private Integer authorId;
	/**
	 * 
	 */
	private Integer isSecret;
	/**
	 * 
	 */
	private Integer likeNumber;
	/**
	 * 
	 */
	private Integer starNumber;
	/**
	 * 
	 */
	private Integer groupId;

}
