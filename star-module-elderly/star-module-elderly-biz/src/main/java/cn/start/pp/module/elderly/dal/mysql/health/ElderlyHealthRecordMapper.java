package cn.start.pp.module.elderly.dal.mysql.health;

import cn.start.pp.framework.common.pojo.PageResult; // 修复
import cn.start.pp.framework.mybatis.core.mapper.BaseMapperX; // 修复
import cn.start.pp.framework.mybatis.core.query.LambdaQueryWrapperX; // 修复
import cn.start.pp.module.elderly.controller.admin.health.vo.ElderlyHealthRecordPageReqVO;
import cn.start.pp.module.elderly.dal.dataobject.health.ElderlyHealthRecordDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ElderlyHealthRecordMapper extends BaseMapperX<ElderlyHealthRecordDO> {

    default PageResult<ElderlyHealthRecordDO> selectPage(ElderlyHealthRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ElderlyHealthRecordDO>()
                .eqIfPresent(ElderlyHealthRecordDO::getElderlyId, reqVO.getElderlyId())
                .eqIfPresent(ElderlyHealthRecordDO::getType, reqVO.getType())
                .orderByDesc(ElderlyHealthRecordDO::getId));
    }
}
