package cn.start.pp.module.elderly.service.order;

import cn.start.pp.framework.common.pojo.PageResult; // 修复
import cn.start.pp.module.elderly.controller.admin.order.vo.ElderlyServiceOrderCancelReqVO;
import cn.start.pp.module.elderly.controller.admin.order.vo.ElderlyServiceOrderCreateReqVO;
import cn.start.pp.module.elderly.controller.admin.order.vo.ElderlyServiceOrderPageReqVO;
import cn.start.pp.module.elderly.dal.dataobject.order.ElderlyServiceOrderDO;

public interface ElderlyServiceOrderService {

    Long createOrder(ElderlyServiceOrderCreateReqVO reqVO);

    void cancelOrder(ElderlyServiceOrderCancelReqVO reqVO);

    ElderlyServiceOrderDO getOrder(Long id);

    PageResult<ElderlyServiceOrderDO> getOrderPage(ElderlyServiceOrderPageReqVO reqVO);
}
