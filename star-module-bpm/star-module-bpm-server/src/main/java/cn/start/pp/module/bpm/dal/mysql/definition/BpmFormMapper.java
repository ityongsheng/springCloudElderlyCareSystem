package cn.start.pp.module.bpm.dal.mysql.definition;


import cn.start.pp.framework.common.pojo.PageResult;
import cn.start.pp.framework.mybatis.core.mapper.BaseMapperX;
import cn.start.pp.framework.mybatis.core.query.QueryWrapperX;
import cn.start.pp.module.bpm.controller.admin.definition.vo.form.BpmFormPageReqVO;
import cn.start.pp.module.bpm.dal.dataobject.definition.BpmFormDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 动态表单 Mapper
 *
 * @author 风里雾里
 */
@Mapper
public interface BpmFormMapper extends BaseMapperX<BpmFormDO> {

    default PageResult<BpmFormDO> selectPage(BpmFormPageReqVO reqVO) {
        return selectPage(reqVO, new QueryWrapperX<BpmFormDO>()
                .likeIfPresent("name", reqVO.getName())
                .orderByDesc("id"));
    }

}
