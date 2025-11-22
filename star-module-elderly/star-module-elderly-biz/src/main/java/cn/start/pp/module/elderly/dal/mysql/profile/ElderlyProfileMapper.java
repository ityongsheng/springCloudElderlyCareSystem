package cn.start.pp.module.elderly.dal.mysql.profile;

import cn.start.pp.framework.common.pojo.PageResult; // 修复
import cn.start.pp.framework.mybatis.core.mapper.BaseMapperX; // 修复
import cn.start.pp.framework.mybatis.core.query.LambdaQueryWrapperX; // 修复
import cn.start.pp.module.elderly.controller.admin.profile.vo.ElderlyProfilePageReqVO;
import cn.start.pp.module.elderly.dal.dataobject.profile.ElderlyProfileDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ElderlyProfileMapper extends BaseMapperX<ElderlyProfileDO> {

    default PageResult<ElderlyProfileDO> selectPage(ElderlyProfilePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ElderlyProfileDO>()
                .likeIfPresent(ElderlyProfileDO::getName, reqVO.getName())
                .eqIfPresent(ElderlyProfileDO::getIdCard, reqVO.getIdCard())
                .orderByDesc(ElderlyProfileDO::getId));
    }
}
