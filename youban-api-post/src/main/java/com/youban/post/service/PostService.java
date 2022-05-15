package com.youban.post.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqupt.entity.PostEntity;
import com.cqupt.utils.PageUtils;

import java.util.Map;

/**
 * @author lzh
 * @email 1138423425@qq.com
 * @date 2022-05-15 20:08:08
 */
public interface PostService extends IService<PostEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

