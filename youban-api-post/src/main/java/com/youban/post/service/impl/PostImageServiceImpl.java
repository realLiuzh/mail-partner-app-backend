package com.youban.post.service.impl;

import com.cqupt.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.utils.PageUtils;
import com.cqupt.utils.R;

import com.youban.post.dao.PostImageDao;
import com.cqupt.entity.PostImageEntity;
import com.youban.post.service.PostImageService;


@Service("postImageService")
public class PostImageServiceImpl extends ServiceImpl<PostImageDao, PostImageEntity> implements PostImageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PostImageEntity> page = this.page(
                new Query<PostImageEntity>().getPage(params),
                new QueryWrapper<PostImageEntity>()
        );

        return new PageUtils(page);
    }

}