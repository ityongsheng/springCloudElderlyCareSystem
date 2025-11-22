package cn.start.pp.module.elderly.convert.order;

import cn.start.pp.module.elderly.controller.admin.order.vo.ElderlyServiceOrderCreateReqVO;
import cn.start.pp.module.elderly.controller.admin.order.vo.ElderlyServiceOrderRespVO;
import cn.start.pp.module.elderly.dal.dataobject.order.ElderlyServiceOrderDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ElderlyServiceOrderConvert {

    ElderlyServiceOrderConvert INSTANCE = Mappers.getMapper(ElderlyServiceOrderConvert.class);

    ElderlyServiceOrderDO convert(ElderlyServiceOrderCreateReqVO bean);

    ElderlyServiceOrderRespVO convert(ElderlyServiceOrderDO bean);

    List<ElderlyServiceOrderRespVO> convertList(List<ElderlyServiceOrderDO> list);
}

