package com.youban.post.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqupt.utils.PageUtils;
import com.cqupt.entity.CommentsEntity;

import java.util.Map;

/**
 * 
 *
 * @author lzh
 * @email 1138423425@qq.com
 * @date 2022-05-15 20:08:07
 */
public interface CommentsService extends IService<CommentsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

