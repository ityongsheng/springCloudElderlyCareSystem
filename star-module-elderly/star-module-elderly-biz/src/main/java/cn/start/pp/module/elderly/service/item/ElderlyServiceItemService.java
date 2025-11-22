package cn.start.pp.module.elderly.service.item;

import cn.start.pp.framework.common.pojo.PageResult;
import cn.start.pp.module.elderly.controller.admin.item.vo.ElderlyServiceItemCreateReqVO;
import cn.start.pp.module.elderly.controller.admin.item.vo.ElderlyServiceItemPageReqVO;
import cn.start.pp.module.elderly.controller.admin.item.vo.ElderlyServiceItemUpdateReqVO;
import cn.start.pp.module.elderly.dal.dataobject.item.ElderlyServiceItemDO;

import java.util.List;

public interface ElderlyServiceItemService {

    Long createServiceItem(ElderlyServiceItemCreateReqVO reqVO);

    void updateServiceItem(ElderlyServiceItemUpdateReqVO reqVO);

    void deleteServiceItem(Long id);

    ElderlyServiceItemDO getServiceItem(Long id);

    PageResult<ElderlyServiceItemDO> getServiceItemPage(ElderlyServiceItemPageReqVO reqVO);

    List<ElderlyServiceItemDO> getSimpleServiceItemList();
}
