package cn.start.pp.module.bpm.dal.mysql.definition;

import cn.start.pp.framework.common.pojo.PageResult;
import cn.start.pp.framework.mybatis.core.mapper.BaseMapperX;
import cn.start.pp.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.start.pp.module.bpm.controller.admin.definition.vo.listener.BpmProcessListenerPageReqVO;
import cn.start.pp.module.bpm.dal.dataobject.definition.BpmProcessListenerDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * BPM 流程监听器 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface BpmProcessListenerMapper extends BaseMapperX<BpmProcessListenerDO> {

    default PageResult<BpmProcessListenerDO> selectPage(BpmProcessListenerPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BpmProcessListenerDO>()
                .likeIfPresent(BpmProcessListenerDO::getName, reqVO.getName())
                .eqIfPresent(BpmProcessListenerDO::getType, reqVO.getType())
                .eqIfPresent(BpmProcessListenerDO::getEvent, reqVO.getEvent())
                .eqIfPresent(BpmProcessListenerDO::getStatus, reqVO.getStatus())
                .orderByDesc(BpmProcessListenerDO::getId));
    }

}