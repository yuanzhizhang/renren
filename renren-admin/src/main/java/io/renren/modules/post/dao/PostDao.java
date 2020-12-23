package io.renren.modules.post.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.post.entity.PostEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-12-22 16:16:12
 */
@Mapper
public interface PostDao extends BaseMapper<PostEntity> {
	
}
