package cn.start.pp.module.elderly.service.profile;

import cn.start.pp.framework.common.pojo.PageResult;
import cn.start.pp.module.elderly.controller.admin.profile.vo.ElderlyProfileCreateReqVO;
import cn.start.pp.module.elderly.controller.admin.profile.vo.ElderlyProfilePageReqVO;
import cn.start.pp.module.elderly.controller.admin.profile.vo.ElderlyProfileUpdateReqVO;
import cn.start.pp.module.elderly.dal.dataobject.profile.ElderlyProfileDO;

import java.util.List;

public interface ElderlyProfileService {

    Long createProfile(ElderlyProfileCreateReqVO reqVO);

    void updateProfile(ElderlyProfileUpdateReqVO reqVO);

    void deleteProfile(Long id);

    ElderlyProfileDO getProfile(Long id);

    PageResult<ElderlyProfileDO> getProfilePage(ElderlyProfilePageReqVO reqVO);

    List<ElderlyProfileDO> getProfileListByIds(List<Long> ids);
}
