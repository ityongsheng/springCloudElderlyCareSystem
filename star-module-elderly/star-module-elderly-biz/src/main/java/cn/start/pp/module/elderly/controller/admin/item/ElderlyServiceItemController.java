package cn.start.pp.module.elderly.controller.admin.item;

import cn.start.pp.framework.common.pojo.CommonResult;
import cn.start.pp.framework.common.pojo.PageResult;
import cn.start.pp.module.elderly.controller.admin.item.vo.*;
import cn.start.pp.module.elderly.convert.item.ElderlyServiceItemConvert;
import cn.start.pp.module.elderly.dal.dataobject.item.ElderlyServiceItemDO;
import cn.start.pp.module.elderly.service.item.ElderlyServiceItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.start.pp.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 服务项目")
@RestController
@RequestMapping("/elderly/service-item")
@Validated
public class ElderlyServiceItemController {

    @Resource
    private ElderlyServiceItemService serviceItemService;

    @PostMapping("/create")
    @Operation(summary = "创建服务项目")
    @PreAuthorize("@ss.hasPermission('elderly:item:create')")
    public CommonResult<Long> createServiceItem(@Valid @RequestBody ElderlyServiceItemCreateReqVO reqVO) {
        return success(serviceItemService.createServiceItem(reqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新服务项目")
    @PreAuthorize("@ss.hasPermission('elderly:item:update')")
    public CommonResult<Boolean> updateServiceItem(@Valid @RequestBody ElderlyServiceItemUpdateReqVO reqVO) {
        serviceItemService.updateServiceItem(reqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除服务项目")
    @PreAuthorize("@ss.hasPermission('elderly:item:delete')")
    public CommonResult<Boolean> deleteServiceItem(@RequestParam("id") Long id) {
        serviceItemService.deleteServiceItem(id);
        return success(true);
    }

    @GetMapping("/page")
    @Operation(summary = "分页查询服务项目")
    @PreAuthorize("@ss.hasPermission('elderly:item:query')")
    public CommonResult<PageResult<ElderlyServiceItemRespVO>> getServiceItemPage(@Valid ElderlyServiceItemPageReqVO reqVO) {
        PageResult<ElderlyServiceItemDO> pageResult = serviceItemService.getServiceItemPage(reqVO);
        List<ElderlyServiceItemRespVO> data = ElderlyServiceItemConvert.INSTANCE.convertList(pageResult.getList());
        return success(new PageResult<>(data, pageResult.getTotal()));
    }

    @GetMapping("/get")
    @Operation(summary = "获取服务项目")
    @PreAuthorize("@ss.hasPermission('elderly:item:query')")
    public CommonResult<ElderlyServiceItemRespVO> getServiceItem(@RequestParam("id") Long id) {
        ElderlyServiceItemDO serviceItem = serviceItemService.getServiceItem(id);
        return success(ElderlyServiceItemConvert.INSTANCE.convert(serviceItem));
    }

    @GetMapping("/list-all-simple")
    @Operation(summary = "获取精简服务项目列表")
    public CommonResult<List<ElderlyServiceItemSimpleRespVO>> listSimpleServiceItems() {
        List<ElderlyServiceItemDO> list = serviceItemService.getSimpleServiceItemList();
        return success(ElderlyServiceItemConvert.INSTANCE.convertSimpleList(list));
    }
}
