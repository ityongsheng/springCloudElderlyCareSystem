package cn.start.pp.module.elderly.controller.admin.order;

import cn.start.pp.framework.common.pojo.CommonResult;
import cn.start.pp.framework.common.pojo.PageResult;
import cn.start.pp.module.elderly.controller.admin.order.vo.ElderlyServiceOrderCancelReqVO;
import cn.start.pp.module.elderly.controller.admin.order.vo.ElderlyServiceOrderCreateReqVO;
import cn.start.pp.module.elderly.controller.admin.order.vo.ElderlyServiceOrderPageReqVO;
import cn.start.pp.module.elderly.controller.admin.order.vo.ElderlyServiceOrderRespVO;
import cn.start.pp.module.elderly.convert.order.ElderlyServiceOrderConvert;
import cn.start.pp.module.elderly.dal.dataobject.order.ElderlyServiceOrderDO;
import cn.start.pp.module.elderly.service.order.ElderlyServiceOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.start.pp.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 服务订单")
@RestController
@RequestMapping("/elderly/service-order")
@Validated
public class ElderlyServiceOrderController {

    @Resource
    private ElderlyServiceOrderService orderService;

    @PostMapping("/create")
    @Operation(summary = "创建服务订单")
    @PreAuthorize("@ss.hasPermission('elderly:order:create')")
    public CommonResult<Long> createOrder(@Valid @RequestBody ElderlyServiceOrderCreateReqVO reqVO) {
        return success(orderService.createOrder(reqVO));
    }

    @PostMapping("/cancel")
    @Operation(summary = "取消服务订单")
    @PreAuthorize("@ss.hasPermission('elderly:order:cancel')")
    public CommonResult<Boolean> cancelOrder(@Valid @RequestBody ElderlyServiceOrderCancelReqVO reqVO) {
        orderService.cancelOrder(reqVO);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获取服务订单")
    @PreAuthorize("@ss.hasPermission('elderly:order:query')")
    public CommonResult<ElderlyServiceOrderRespVO> getOrder(@RequestParam("id") Long id) {
        ElderlyServiceOrderDO order = orderService.getOrder(id);
        return success(ElderlyServiceOrderConvert.INSTANCE.convert(order));
    }

    @GetMapping("/page")
    @Operation(summary = "分页查询服务订单")
    @PreAuthorize("@ss.hasPermission('elderly:order:query')")
    public CommonResult<PageResult<ElderlyServiceOrderRespVO>> getOrderPage(@Valid ElderlyServiceOrderPageReqVO reqVO) {
        PageResult<ElderlyServiceOrderDO> pageResult = orderService.getOrderPage(reqVO);
        List<ElderlyServiceOrderRespVO> data = ElderlyServiceOrderConvert.INSTANCE.convertList(pageResult.getList());
        return success(new PageResult<>(data, pageResult.getTotal()));
    }
}
