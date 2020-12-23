package io.renren.modules.board.service.impl;

import io.renren.modules.board.dao.TBoardDao;
import io.renren.modules.board.entity.TBoardEntity;
import io.renren.modules.board.service.TBoardService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;



@Service("tBoardService")
public class TBoardServiceImpl extends ServiceImpl<TBoardDao, TBoardEntity> implements TBoardService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TBoardEntity> page = this.page(
                new Query<TBoardEntity>().getPage(params),
                new QueryWrapper<TBoardEntity>()
        );

        return new PageUtils(page);
    }

}
