package cn.start.pp.module.elderly.convert.item;

import cn.start.pp.module.elderly.controller.admin.item.vo.ElderlyServiceItemCreateReqVO;
import cn.start.pp.module.elderly.controller.admin.item.vo.ElderlyServiceItemRespVO;
import cn.start.pp.module.elderly.controller.admin.item.vo.ElderlyServiceItemSimpleRespVO;
import cn.start.pp.module.elderly.controller.admin.item.vo.ElderlyServiceItemUpdateReqVO;
import cn.start.pp.module.elderly.dal.dataobject.item.ElderlyServiceItemDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ElderlyServiceItemConvert {

    ElderlyServiceItemConvert INSTANCE = Mappers.getMapper(ElderlyServiceItemConvert.class);

    ElderlyServiceItemDO convert(ElderlyServiceItemCreateReqVO bean);

    ElderlyServiceItemDO convert(ElderlyServiceItemUpdateReqVO bean);

    ElderlyServiceItemRespVO convert(ElderlyServiceItemDO bean);

    List<ElderlyServiceItemRespVO> convertList(List<ElderlyServiceItemDO> list);

    List<ElderlyServiceItemSimpleRespVO> convertSimpleList(List<ElderlyServiceItemDO> list);
}

