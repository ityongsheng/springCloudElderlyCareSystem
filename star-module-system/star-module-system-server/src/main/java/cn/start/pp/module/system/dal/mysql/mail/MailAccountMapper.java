package cn.start.pp.module.system.dal.mysql.mail;

import cn.start.pp.framework.common.pojo.PageResult;
import cn.start.pp.framework.mybatis.core.mapper.BaseMapperX;
import cn.start.pp.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.start.pp.module.system.controller.admin.mail.vo.account.MailAccountPageReqVO;
import cn.start.pp.module.system.dal.dataobject.mail.MailAccountDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MailAccountMapper extends BaseMapperX<MailAccountDO> {

    default PageResult<MailAccountDO> selectPage(MailAccountPageReqVO pageReqVO) {
        return selectPage(pageReqVO, new LambdaQueryWrapperX<MailAccountDO>()
                .likeIfPresent(MailAccountDO::getMail, pageReqVO.getMail())
                .likeIfPresent(MailAccountDO::getUsername , pageReqVO.getUsername())
                .orderByDesc(MailAccountDO::getId));
    }

}
