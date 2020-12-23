package io.renren.modules.post_repay.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.post_repay.entity.PostReplyEntity;


import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-12-22 18:53:24
 */
public interface PostReplyService extends IService<PostReplyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

