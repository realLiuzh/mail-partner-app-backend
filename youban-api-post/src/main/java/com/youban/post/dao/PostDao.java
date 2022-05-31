package com.youban.post.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.entity.PostEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqupt.query.PostQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface PostDao extends BaseMapper<PostEntity> {

    List<PostEntity> searchList(Page<PostEntity> page, PostQuery postQuery);
}
