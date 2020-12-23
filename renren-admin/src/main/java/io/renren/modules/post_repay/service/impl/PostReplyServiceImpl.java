package io.renren.modules.post_repay.service.impl;

import io.renren.modules.post_repay.dao.PostReplyDao;
import io.renren.modules.post_repay.entity.PostReplyEntity;
import io.renren.modules.post_repay.service.PostReplyService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;




@Service("postReplyService")
public class PostReplyServiceImpl extends ServiceImpl<PostReplyDao, PostReplyEntity> implements PostReplyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PostReplyEntity> page = this.page(
                new Query<PostReplyEntity>().getPage(params),
                new QueryWrapper<PostReplyEntity>()
        );

        return new PageUtils(page);
    }

}
