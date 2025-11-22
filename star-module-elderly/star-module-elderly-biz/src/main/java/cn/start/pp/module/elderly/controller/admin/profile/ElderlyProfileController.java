package cn.start.pp.module.elderly.controller.admin.profile;

import cn.start.pp.framework.common.pojo.CommonResult;
import cn.start.pp.framework.common.pojo.PageResult;
import cn.start.pp.module.elderly.controller.admin.profile.vo.*;
import cn.start.pp.module.elderly.convert.profile.ElderlyProfileConvert;
import cn.start.pp.module.elderly.dal.dataobject.profile.ElderlyProfileDO;
import cn.start.pp.module.elderly.service.profile.ElderlyProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.start.pp.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 老人档案")
@RestController
@RequestMapping("/elderly/profile")
@Validated
public class ElderlyProfileController {

    @Resource
    private ElderlyProfileService profileService;

    @PostMapping("/create")
    @Operation(summary = "创建老人档案")
    @PreAuthorize("@ss.hasPermission('elderly:profile:create')")
    public CommonResult<Long> createProfile(@Valid @RequestBody ElderlyProfileCreateReqVO reqVO) {
        return success(profileService.createProfile(reqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新老人档案")
    @PreAuthorize("@ss.hasPermission('elderly:profile:update')")
    public CommonResult<Boolean> updateProfile(@Valid @RequestBody ElderlyProfileUpdateReqVO reqVO) {
        profileService.updateProfile(reqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除老人档案")
    @PreAuthorize("@ss.hasPermission('elderly:profile:delete')")
    public CommonResult<Boolean> deleteProfile(@RequestParam("id") Long id) {
        profileService.deleteProfile(id);
        return success(true);
    }

    @GetMapping("/page")
    @Operation(summary = "分页查询老人档案")
    @PreAuthorize("@ss.hasPermission('elderly:profile:query')")
    public CommonResult<PageResult<ElderlyProfileRespVO>> getProfilePage(@Valid ElderlyProfilePageReqVO reqVO) {
        PageResult<ElderlyProfileDO> pageResult = profileService.getProfilePage(reqVO);
        List<ElderlyProfileRespVO> data = ElderlyProfileConvert.INSTANCE.convertList(pageResult.getList());
        return success(new PageResult<>(data, pageResult.getTotal()));
    }

    @GetMapping("/get")
    @Operation(summary = "获取老人档案详情")
    @PreAuthorize("@ss.hasPermission('elderly:profile:query')")
    public CommonResult<ElderlyProfileRespVO> getProfile(@RequestParam("id") Long id) {
        ElderlyProfileDO profile = profileService.getProfile(id);
        return success(ElderlyProfileConvert.INSTANCE.convert(profile));
    }

    @GetMapping("/list")
    @Operation(summary = "批量查询老人档案")
    @PreAuthorize("@ss.hasPermission('elderly:profile:query')")
    public CommonResult<List<ElderlyProfileRespVO>> getProfileList(@RequestParam("ids") List<Long> ids) {
        List<ElderlyProfileDO> profiles = profileService.getProfileListByIds(ids);
        return success(ElderlyProfileConvert.INSTANCE.convertList(profiles));
    }
}
