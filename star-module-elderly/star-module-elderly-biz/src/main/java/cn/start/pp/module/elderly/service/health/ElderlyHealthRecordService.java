package cn.start.pp.module.elderly.service.health;

import cn.start.pp.framework.common.pojo.PageResult; // 修复
import cn.start.pp.module.elderly.controller.admin.health.vo.ElderlyHealthRecordCreateReqVO;
import cn.start.pp.module.elderly.controller.admin.health.vo.ElderlyHealthRecordPageReqVO;
import cn.start.pp.module.elderly.dal.dataobject.health.ElderlyHealthRecordDO;

public interface ElderlyHealthRecordService {

    Long createHealthRecord(ElderlyHealthRecordCreateReqVO reqVO);

    ElderlyHealthRecordDO getHealthRecord(Long id);

    PageResult<ElderlyHealthRecordDO> getHealthRecordPage(ElderlyHealthRecordPageReqVO reqVO);
}
