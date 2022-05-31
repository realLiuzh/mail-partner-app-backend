package com.youban.post.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cqupt.entity.PostImageEntity;
import com.youban.post.service.PostImageService;
import com.cqupt.utils.PageUtils;
import com.cqupt.utils.R;


@RestController
@RequestMapping("post/postimage")
public class PostImageController {
    @Autowired
    private PostImageService postImageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("post:postimage:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = postImageService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("post:postimage:info")
    public R info(@PathVariable("id") Integer id){
		PostImageEntity postImage = postImageService.getById(id);

        return R.ok().put("postImage", postImage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("post:postimage:save")
    public R save(@RequestBody PostImageEntity postImage){
		postImageService.save(postImage);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("post:postimage:update")
    public R update(@RequestBody PostImageEntity postImage){
		postImageService.updateById(postImage);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("post:postimage:delete")
    public R delete(@RequestBody Integer[] ids){
		postImageService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
