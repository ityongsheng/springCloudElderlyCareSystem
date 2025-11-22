package cn.start.pp.module.elderly.service.health.impl;

import cn.start.pp.framework.common.pojo.PageResult;
import cn.start.pp.framework.common.exception.util.ServiceExceptionUtil;
import cn.start.pp.module.elderly.controller.admin.health.vo.ElderlyHealthRecordCreateReqVO;
import cn.start.pp.module.elderly.controller.admin.health.vo.ElderlyHealthRecordPageReqVO;
import cn.start.pp.module.elderly.convert.health.ElderlyHealthRecordConvert;
import cn.start.pp.module.elderly.dal.dataobject.health.ElderlyHealthRecordDO;
import cn.start.pp.module.elderly.dal.mysql.health.ElderlyHealthRecordMapper;
import cn.start.pp.module.elderly.enums.ErrorCodeConstants;
import cn.start.pp.module.elderly.service.health.ElderlyHealthRecordService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.annotation.Resource;

import static cn.start.pp.module.elderly.enums.ErrorCodeConstants.ELDERLY_HEALTH_RECORD_NOT_FOUND;

@Service
@Validated
public class ElderlyHealthRecordServiceImpl implements ElderlyHealthRecordService {

    @Resource
    private ElderlyHealthRecordMapper healthRecordMapper;

    @Override
    public Long createHealthRecord(ElderlyHealthRecordCreateReqVO reqVO) {
        ElderlyHealthRecordDO record = ElderlyHealthRecordConvert.INSTANCE.convert(reqVO);
        healthRecordMapper.insert(record);
        return record.getId();
    }

    @Override
    public ElderlyHealthRecordDO getHealthRecord(Long id) {
        ElderlyHealthRecordDO record = healthRecordMapper.selectById(id);
        if (record == null) {
            throw ServiceExceptionUtil.exception(ELDERLY_HEALTH_RECORD_NOT_FOUND);
        }
        return record;
    }

    @Override
    public PageResult<ElderlyHealthRecordDO> getHealthRecordPage(ElderlyHealthRecordPageReqVO reqVO) {
        return healthRecordMapper.selectPage(reqVO);
    }
}
