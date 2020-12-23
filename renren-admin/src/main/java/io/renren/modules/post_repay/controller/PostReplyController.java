package io.renren.modules.post_repay.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.post_repay.entity.PostReplyEntity;
import io.renren.modules.post_repay.service.PostReplyService;
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
 * @date 2020-12-22 18:53:24
 */
@RestController
@RequestMapping("post_reply/postreply")
public class PostReplyController {
    @Autowired
    private PostReplyService postReplyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("post_reply:postreply:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = postReplyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{cid}")
    @RequiresPermissions("post_reply:postreply:info")
    public R info(@PathVariable("cid") Integer cid){
        PostReplyEntity postReply = postReplyService.getById(cid);

        return R.ok().put("postReply", postReply);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("post_reply:postreply:save")
    public R save(@RequestBody PostReplyEntity postReply){
        postReplyService.save(postReply);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("post_reply:postreply:update")
    public R update(@RequestBody PostReplyEntity postReply){
        ValidatorUtils.validateEntity(postReply);
        postReplyService.updateById(postReply);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("post_reply:postreply:delete")
    public R delete(@RequestBody Integer[] cids){
        postReplyService.removeByIds(Arrays.asList(cids));

        return R.ok();
    }

}
