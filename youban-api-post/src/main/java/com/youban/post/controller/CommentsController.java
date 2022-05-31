package com.youban.post.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.cqupt.utils.PageUtils;
import com.cqupt.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cqupt.entity.CommentsEntity;
import com.youban.post.service.CommentsService;




@RestController
@RequestMapping("post/comments")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("post:comments:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = commentsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("post:comments:info")
    public R info(@PathVariable("id") Integer id){
		CommentsEntity comments = commentsService.getById(id);

        return R.ok().put("comments", comments);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("post:comments:save")
    public R save(@RequestBody CommentsEntity comments){
		commentsService.save(comments);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("post:comments:update")
    public R update(@RequestBody CommentsEntity comments){
		commentsService.updateById(comments);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("post:comments:delete")
    public R delete(@RequestBody Integer[] ids){
		commentsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
