package com.youban.post.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqupt.entity.PostImageEntity;
import com.cqupt.utils.PageUtils;

import java.util.Map;


public interface PostImageService extends IService<PostImageEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

