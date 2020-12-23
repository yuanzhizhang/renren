package io.renren.modules.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.user.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-12-22 18:53:06
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
	
}
