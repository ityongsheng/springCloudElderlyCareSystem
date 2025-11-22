package cn.start.pp.module.elderly.dal.mysql.order;

import cn.start.pp.framework.common.pojo.PageResult; // 修复
import cn.start.pp.framework.mybatis.core.mapper.BaseMapperX; // 修复
import cn.start.pp.framework.mybatis.core.query.LambdaQueryWrapperX; // 修复
import cn.start.pp.module.elderly.controller.admin.order.vo.ElderlyServiceOrderPageReqVO;
import cn.start.pp.module.elderly.dal.dataobject.order.ElderlyServiceOrderDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ElderlyServiceOrderMapper extends BaseMapperX<ElderlyServiceOrderDO> {

    default PageResult<ElderlyServiceOrderDO> selectPage(ElderlyServiceOrderPageReqVO reqVO) {
        LambdaQueryWrapperX<ElderlyServiceOrderDO> query = new LambdaQueryWrapperX<>();
        query.eqIfPresent(ElderlyServiceOrderDO::getElderlyId, reqVO.getElderlyId());
        query.eqIfPresent(ElderlyServiceOrderDO::getStatus, reqVO.getStatus());
        query.orderByDesc(ElderlyServiceOrderDO::getId);
        return selectPage(reqVO, query);
    }
}
