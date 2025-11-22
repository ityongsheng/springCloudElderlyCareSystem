package cn.start.pp.module.elderly.convert.health;

import cn.start.pp.module.elderly.controller.admin.health.vo.ElderlyHealthRecordCreateReqVO;
import cn.start.pp.module.elderly.controller.admin.health.vo.ElderlyHealthRecordRespVO;
import cn.start.pp.module.elderly.dal.dataobject.health.ElderlyHealthRecordDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ElderlyHealthRecordConvert {

    ElderlyHealthRecordConvert INSTANCE = Mappers.getMapper(ElderlyHealthRecordConvert.class);

    ElderlyHealthRecordDO convert(ElderlyHealthRecordCreateReqVO bean);

    ElderlyHealthRecordRespVO convert(ElderlyHealthRecordDO bean);

    List<ElderlyHealthRecordRespVO> convertList(List<ElderlyHealthRecordDO> list);
}

