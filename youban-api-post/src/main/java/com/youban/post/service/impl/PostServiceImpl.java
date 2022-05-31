package com.youban.post.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.query.PostQuery;
import com.cqupt.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.utils.PageUtils;

import com.youban.post.dao.PostDao;
import com.cqupt.entity.PostEntity;
import com.youban.post.service.PostService;


@Service("postService")
public class PostServiceImpl extends ServiceImpl<PostDao, PostEntity> implements PostService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PostEntity> page = this.page(
                new Query<PostEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils searchList(PostQuery postQuery) {
        Page<PostEntity> page = new Page<>(postQuery.getPage(), postQuery.getLimit());
        baseMapper.searchList(page,postQuery);

        return new PageUtils(page);
    }

}