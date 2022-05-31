package com.youban.post.controller;

import java.util.Arrays;

import com.cqupt.query.PostQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.cqupt.entity.PostEntity;
import com.youban.post.service.PostService;
import com.cqupt.utils.PageUtils;
import com.cqupt.utils.R;


@RestController
@RequestMapping("post")
public class PostController {

    @Autowired
    private PostService postService;

    /**
     * 查询首页动态列表接口
     */
    @GetMapping("/search/list")
    public R searchList(PostQuery postQuery){
        PageUtils page = postService.searchList(postQuery);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("post:post:info")
    public R info(@PathVariable("id") Integer id){
		PostEntity post = postService.getById(id);

        return R.ok().put("post", post);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("post:post:save")
    public R save(@RequestBody PostEntity post){
		postService.save(post);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("post:post:update")
    public R update(@RequestBody PostEntity post){
		postService.updateById(post);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("post:post:delete")
    public R delete(@RequestBody Integer[] ids){
		postService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
