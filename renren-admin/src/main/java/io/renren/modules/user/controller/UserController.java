package io.renren.modules.user.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.board.entity.TBoardEntity;
import io.renren.modules.user.entity.UserEntity;
import io.renren.modules.user.service.UserService;
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
 * @date 2020-12-22 18:53:06
 */
@RestController
@RequestMapping("user/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("user:user:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{uid}")
    @RequiresPermissions("user:user:info")
    public R info(@PathVariable("uid") Integer uid){
        UserEntity user = userService.getById(uid);

        return R.ok().put("user", user);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("user:user:save")
    public R save(@RequestBody UserEntity user){
        userService.save(user);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("user:user:update")
    public R update(@RequestBody UserEntity user){
        ValidatorUtils.validateEntity(user);
        userService.updateById(user);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("user:user:delete")
    public R delete(@RequestBody Integer[] uids){
        userService.removeByIds(Arrays.asList(uids));

        return R.ok();
    }

    @RequestMapping("/dict")
    public R dict(){
        List<UserEntity> list = userService.list();
        return R.ok().put("list", list);
    }

}
