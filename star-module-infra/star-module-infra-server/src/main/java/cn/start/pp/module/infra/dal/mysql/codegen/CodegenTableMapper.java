package cn.start.pp.module.infra.dal.mysql.codegen;

import cn.start.pp.framework.common.pojo.PageResult;
import cn.start.pp.framework.mybatis.core.mapper.BaseMapperX;
import cn.start.pp.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.start.pp.module.infra.controller.admin.codegen.vo.table.CodegenTablePageReqVO;
import cn.start.pp.module.infra.dal.dataobject.codegen.CodegenTableDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CodegenTableMapper extends BaseMapperX<CodegenTableDO> {

    default CodegenTableDO selectByTableNameAndDataSourceConfigId(String tableName, Long dataSourceConfigId) {
        return selectOne(CodegenTableDO::getTableName, tableName,
                CodegenTableDO::getDataSourceConfigId, dataSourceConfigId);
    }

    default PageResult<CodegenTableDO> selectPage(CodegenTablePageReqVO pageReqVO) {
        return selectPage(pageReqVO, new LambdaQueryWrapperX<CodegenTableDO>()
                .likeIfPresent(CodegenTableDO::getTableName, pageReqVO.getTableName())
                .likeIfPresent(CodegenTableDO::getTableComment, pageReqVO.getTableComment())
                .likeIfPresent(CodegenTableDO::getClassName, pageReqVO.getClassName())
                .betweenIfPresent(CodegenTableDO::getCreateTime, pageReqVO.getCreateTime())
                .orderByDesc(CodegenTableDO::getUpdateTime)
        );
    }

    default List<CodegenTableDO> selectListByDataSourceConfigId(Long dataSourceConfigId) {
        return selectList(CodegenTableDO::getDataSourceConfigId, dataSourceConfigId);
    }

    default List<CodegenTableDO> selectListByTemplateTypeAndMasterTableId(Integer templateType, Long masterTableId) {
        return selectList(CodegenTableDO::getTemplateType, templateType,
                CodegenTableDO::getMasterTableId, masterTableId);
    }

}
