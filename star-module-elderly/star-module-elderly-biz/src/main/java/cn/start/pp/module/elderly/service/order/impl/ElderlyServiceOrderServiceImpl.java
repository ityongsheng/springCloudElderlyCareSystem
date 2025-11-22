package cn.start.pp.module.elderly.service.order.impl;

import cn.start.pp.framework.common.pojo.PageResult;
import cn.start.pp.framework.common.exception.util.ServiceExceptionUtil;
import cn.start.pp.module.elderly.controller.admin.order.vo.ElderlyServiceOrderCancelReqVO;
import cn.start.pp.module.elderly.controller.admin.order.vo.ElderlyServiceOrderCreateReqVO;
import cn.start.pp.module.elderly.controller.admin.order.vo.ElderlyServiceOrderPageReqVO;
import cn.start.pp.module.elderly.convert.order.ElderlyServiceOrderConvert;
import cn.start.pp.module.elderly.dal.dataobject.order.ElderlyServiceOrderDO;
import cn.start.pp.module.elderly.dal.mysql.order.ElderlyServiceOrderMapper;
import cn.start.pp.module.elderly.enums.ErrorCodeConstants;
import cn.start.pp.module.elderly.service.order.ElderlyServiceOrderService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.annotation.Resource;
import java.math.BigDecimal;

import static cn.start.pp.module.elderly.enums.ErrorCodeConstants.ELDERLY_SERVICE_ORDER_NOT_FOUND;
import static cn.start.pp.module.elderly.enums.ErrorCodeConstants.ELDERLY_ORDER_STATUS_INVALID;

@Service
@Validated
public class ElderlyServiceOrderServiceImpl implements ElderlyServiceOrderService {

    @Resource
    private ElderlyServiceOrderMapper orderMapper;

    @Override
    public Long createOrder(ElderlyServiceOrderCreateReqVO reqVO) {
        ElderlyServiceOrderDO order = ElderlyServiceOrderConvert.INSTANCE.convert(reqVO);
        // 价格与金额计算逻辑示例：此处应从 ServiceItem 获取价格，这里假设已经注入或后续完善
        if (order.getPrice() == null) {
            order.setPrice(BigDecimal.ZERO);
        }
        order.setAmount(order.getPrice().multiply(BigDecimal.valueOf(order.getQuantity() == null ? 1 : order.getQuantity())));
        orderMapper.insert(order);
        return order.getId();
    }

    @Override
    public void cancelOrder(ElderlyServiceOrderCancelReqVO reqVO) {
        ElderlyServiceOrderDO dbOrder = orderMapper.selectById(reqVO.getId());
        if (dbOrder == null) {
            throw ServiceExceptionUtil.exception(ELDERLY_SERVICE_ORDER_NOT_FOUND);
        }
        // 简单状态校验示例：假设非 1 状态不可取消
        if (dbOrder.getStatus() != null && dbOrder.getStatus() != 1) {
            throw ServiceExceptionUtil.exception(ELDERLY_ORDER_STATUS_INVALID);
        }
        dbOrder.setCancelReason(reqVO.getCancelReason());
        dbOrder.setStatus(0); // 0 表示已取消
        orderMapper.updateById(dbOrder);
    }

    @Override
    public ElderlyServiceOrderDO getOrder(Long id) {
        return orderMapper.selectById(id);
    }

    @Override
    public PageResult<ElderlyServiceOrderDO> getOrderPage(ElderlyServiceOrderPageReqVO reqVO) {
        return orderMapper.selectPage(reqVO);
    }
}
