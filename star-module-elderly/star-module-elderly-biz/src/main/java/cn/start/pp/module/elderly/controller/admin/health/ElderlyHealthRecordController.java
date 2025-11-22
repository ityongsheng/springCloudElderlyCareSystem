package cn.start.pp.module.elderly.controller.admin.health;

import cn.start.pp.framework.common.pojo.CommonResult;
import cn.start.pp.framework.common.pojo.PageResult;
import cn.start.pp.module.elderly.controller.admin.health.vo.ElderlyHealthRecordCreateReqVO;
import cn.start.pp.module.elderly.controller.admin.health.vo.ElderlyHealthRecordPageReqVO;
import cn.start.pp.module.elderly.controller.admin.health.vo.ElderlyHealthRecordRespVO;
import cn.start.pp.module.elderly.convert.health.ElderlyHealthRecordConvert;
import cn.start.pp.module.elderly.dal.dataobject.health.ElderlyHealthRecordDO;
import cn.start.pp.module.elderly.service.health.ElderlyHealthRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.start.pp.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 健康监测")
@RestController
@RequestMapping("/elderly/health")
@Validated
public class ElderlyHealthRecordController {

    @Resource
    private ElderlyHealthRecordService healthRecordService;

    @PostMapping("/create")
    @Operation(summary = "创建健康监测记录")
    @PreAuthorize("@ss.hasPermission('elderly:health:create')")
    public CommonResult<Long> createHealthRecord(@Valid @RequestBody ElderlyHealthRecordCreateReqVO reqVO) {
        return success(healthRecordService.createHealthRecord(reqVO));
    }

    @GetMapping("/get")
    @Operation(summary = "获取健康监测记录")
    @PreAuthorize("@ss.hasPermission('elderly:health:query')")
    public CommonResult<ElderlyHealthRecordRespVO> getHealthRecord(@RequestParam("id") Long id) {
        ElderlyHealthRecordDO record = healthRecordService.getHealthRecord(id);
        return success(ElderlyHealthRecordConvert.INSTANCE.convert(record));
    }

    @GetMapping("/page")
    @Operation(summary = "分页查询健康监测记录")
    @PreAuthorize("@ss.hasPermission('elderly:health:query')")
    public CommonResult<PageResult<ElderlyHealthRecordRespVO>> getHealthRecordPage(@Valid ElderlyHealthRecordPageReqVO reqVO) {
        PageResult<ElderlyHealthRecordDO> pageResult = healthRecordService.getHealthRecordPage(reqVO);
        List<ElderlyHealthRecordRespVO> data = ElderlyHealthRecordConvert.INSTANCE.convertList(pageResult.getList());
        return success(new PageResult<>(data, pageResult.getTotal()));
    }
}
