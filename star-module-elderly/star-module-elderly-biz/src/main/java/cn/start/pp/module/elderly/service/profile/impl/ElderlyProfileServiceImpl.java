package cn.start.pp.module.elderly.service.profile.impl;

import cn.start.pp.framework.common.exception.util.ServiceExceptionUtil;
import cn.start.pp.framework.common.pojo.PageResult;
import cn.start.pp.module.elderly.controller.admin.profile.vo.ElderlyProfileCreateReqVO;
import cn.start.pp.module.elderly.controller.admin.profile.vo.ElderlyProfilePageReqVO;
import cn.start.pp.module.elderly.controller.admin.profile.vo.ElderlyProfileUpdateReqVO;
import cn.start.pp.module.elderly.convert.profile.ElderlyProfileConvert;
import cn.start.pp.module.elderly.dal.dataobject.profile.ElderlyProfileDO;
import cn.start.pp.module.elderly.dal.mysql.profile.ElderlyProfileMapper;
import cn.start.pp.module.elderly.enums.ErrorCodeConstants;
import cn.start.pp.module.elderly.service.profile.ElderlyProfileService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.annotation.Resource;
import java.util.List;

import static cn.start.pp.module.elderly.enums.ErrorCodeConstants.ELDERLY_PROFILE_NOT_FOUND;

@Service
@Validated
public class ElderlyProfileServiceImpl implements ElderlyProfileService {

    @Resource
    private ElderlyProfileMapper profileMapper;

    @Override
    public Long createProfile(ElderlyProfileCreateReqVO reqVO) {
        ElderlyProfileDO profile = ElderlyProfileConvert.INSTANCE.convert(reqVO);
        profileMapper.insert(profile);
        return profile.getId();
    }

    @Override
    public void updateProfile(ElderlyProfileUpdateReqVO reqVO) {
        ElderlyProfileDO dbProfile = profileMapper.selectById(reqVO.getId());
        if (dbProfile == null) {
            throw ServiceExceptionUtil.exception(ELDERLY_PROFILE_NOT_FOUND);
        }
        profileMapper.updateById(ElderlyProfileConvert.INSTANCE.convert(reqVO));
    }

    @Override
    public void deleteProfile(Long id) {
        ElderlyProfileDO dbProfile = profileMapper.selectById(id);
        if (dbProfile == null) {
            throw ServiceExceptionUtil.exception(ELDERLY_PROFILE_NOT_FOUND);
        }
        profileMapper.deleteById(id);
    }

    @Override
    public ElderlyProfileDO getProfile(Long id) {
        return profileMapper.selectById(id);
    }

    @Override
    public PageResult<ElderlyProfileDO> getProfilePage(ElderlyProfilePageReqVO reqVO) {
        return profileMapper.selectPage(reqVO);
    }

    @Override
    public List<ElderlyProfileDO> getProfileListByIds(List<Long> ids) {
        return profileMapper.selectBatchIds(ids);
    }
}
