package cn.start.pp.module.elderly.dal.mysql.item;

import cn.start.pp.framework.common.pojo.PageResult; // 修复
import cn.start.pp.framework.mybatis.core.mapper.BaseMapperX; // 修复
import cn.start.pp.framework.mybatis.core.query.LambdaQueryWrapperX; // 修复
import cn.start.pp.module.elderly.controller.admin.item.vo.ElderlyServiceItemPageReqVO;
import cn.start.pp.module.elderly.dal.dataobject.item.ElderlyServiceItemDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ElderlyServiceItemMapper extends BaseMapperX<ElderlyServiceItemDO> {

    default PageResult<ElderlyServiceItemDO> selectPage(ElderlyServiceItemPageReqVO reqVO) {
        LambdaQueryWrapperX<ElderlyServiceItemDO> query = new LambdaQueryWrapperX<>();
        query.likeIfPresent(ElderlyServiceItemDO::getName, reqVO.getName());
        query.eqIfPresent(ElderlyServiceItemDO::getStatus, reqVO.getStatus());
        query.orderByDesc(ElderlyServiceItemDO::getId);
        return selectPage(reqVO, query);
    }

    default List<ElderlyServiceItemDO> selectSimpleList() {
        return selectList(new LambdaQueryWrapperX<ElderlyServiceItemDO>()
                .eq(ElderlyServiceItemDO::getStatus, 1)
                .orderByAsc(ElderlyServiceItemDO::getName));
    }
}
