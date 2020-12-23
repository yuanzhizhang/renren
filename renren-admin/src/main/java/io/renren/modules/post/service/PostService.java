package io.renren.modules.post.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.post.entity.PostEntity;


import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-12-22 16:16:12
 */
public interface PostService extends IService<PostEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

