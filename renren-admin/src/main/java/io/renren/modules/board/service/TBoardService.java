package io.renren.modules.board.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.board.entity.TBoardEntity;

import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-12-18 16:14:05
 */
public interface TBoardService extends IService<TBoardEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

