package io.renren.modules.post.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.post.entity.PostEntity;
import io.renren.modules.post.service.PostService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-12-22 16:16:12
 */
@RestController
@RequestMapping("post/post")
public class PostController {
    @Autowired
    private PostService postService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("post:post:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = postService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("post:post:info")
    public R info(@PathVariable("id") Integer id){
        PostEntity post = postService.getById(id);

        return R.ok().put("post", post);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("post:post:save")
    public R save(@RequestBody PostEntity post){
        postService.save(post);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("post:post:update")
    public R update(@RequestBody PostEntity post){
        System.out.println(post);
        ValidatorUtils.validateEntity(post);
        postService.updateById(post);
        System.out.println(post);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("post:post:delete")
    public R delete(@RequestBody Integer[] ids){
        postService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
