package com.youban.post.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqupt.utils.PageUtils;
import com.cqupt.entity.CommentsEntity;

import java.util.Map;

public interface CommentsService extends IService<CommentsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

