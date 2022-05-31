package com.youban.post.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqupt.entity.PostEntity;
import com.cqupt.query.PostQuery;
import com.cqupt.utils.PageUtils;

import java.util.Map;


public interface PostService extends IService<PostEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils searchList(PostQuery postQuery);
}

