package cn.start.pp.module.elderly.convert.profile;

import cn.start.pp.module.elderly.controller.admin.profile.vo.ElderlyProfileCreateReqVO;
import cn.start.pp.module.elderly.controller.admin.profile.vo.ElderlyProfileRespVO;
import cn.start.pp.module.elderly.controller.admin.profile.vo.ElderlyProfileUpdateReqVO;
import cn.start.pp.module.elderly.dal.dataobject.profile.ElderlyProfileDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ElderlyProfileConvert {

    ElderlyProfileConvert INSTANCE = Mappers.getMapper(ElderlyProfileConvert.class);

    ElderlyProfileDO convert(ElderlyProfileCreateReqVO bean);

    ElderlyProfileDO convert(ElderlyProfileUpdateReqVO bean);

    ElderlyProfileRespVO convert(ElderlyProfileDO bean);

    List<ElderlyProfileRespVO> convertList(List<ElderlyProfileDO> list);
}

