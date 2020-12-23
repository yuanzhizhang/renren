package io.renren.modules.board.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.board.entity.TBoardEntity;
import io.renren.modules.board.service.TBoardService;
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
 * @date 2020-12-18 16:14:05
 */
@RestController
@RequestMapping("board/tboard")
public class TBoardController {
    @Autowired
    private TBoardService tBoardService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("board:tboard:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tBoardService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{bid}")
    @RequiresPermissions("board:tboard:info")
    public R info(@PathVariable("bid") Integer bid){
        TBoardEntity tBoard = tBoardService.getById(bid);

        return R.ok().put("tBoard", tBoard);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("board:tboard:save")
    public R save(@RequestBody TBoardEntity tBoard){
        tBoardService.save(tBoard);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("board:tboard:update")
    public R update(@RequestBody TBoardEntity tBoard){
        ValidatorUtils.validateEntity(tBoard);
        tBoardService.updateById(tBoard);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("board:tboard:delete")
    public R delete(@RequestBody Integer[] bids){
        tBoardService.removeByIds(Arrays.asList(bids));

        return R.ok();
    }

    @RequestMapping("/dict")
    public R dict(){
        List<TBoardEntity> list = tBoardService.list();
        System.out.println("1111111111111111111111111"+list.get(1).getBoardname());
        return R.ok().put("list", list);
    }

}
