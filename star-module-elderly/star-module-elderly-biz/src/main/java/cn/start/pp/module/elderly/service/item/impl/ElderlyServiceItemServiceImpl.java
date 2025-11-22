package cn.start.pp.module.elderly.service.item.impl;

import cn.start.pp.framework.common.pojo.PageResult;
import cn.start.pp.framework.common.exception.util.ServiceExceptionUtil;
import cn.start.pp.module.elderly.controller.admin.item.vo.ElderlyServiceItemCreateReqVO;
import cn.start.pp.module.elderly.controller.admin.item.vo.ElderlyServiceItemPageReqVO;
import cn.start.pp.module.elderly.controller.admin.item.vo.ElderlyServiceItemUpdateReqVO;
import cn.start.pp.module.elderly.convert.item.ElderlyServiceItemConvert;
import cn.start.pp.module.elderly.dal.dataobject.item.ElderlyServiceItemDO;
import cn.start.pp.module.elderly.dal.mysql.item.ElderlyServiceItemMapper;
import cn.start.pp.module.elderly.enums.ErrorCodeConstants;
import cn.start.pp.module.elderly.service.item.ElderlyServiceItemService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.annotation.Resource;
import java.util.List;

import static cn.start.pp.module.elderly.enums.ErrorCodeConstants.ELDERLY_SERVICE_ITEM_NOT_FOUND;

@Service
@Validated
public class ElderlyServiceItemServiceImpl implements ElderlyServiceItemService {

    @Resource
    private ElderlyServiceItemMapper serviceItemMapper;

    @Override
    public Long createServiceItem(ElderlyServiceItemCreateReqVO reqVO) {
        ElderlyServiceItemDO item = ElderlyServiceItemConvert.INSTANCE.convert(reqVO);
        serviceItemMapper.insert(item);
        return item.getId();
    }

    @Override
    public void updateServiceItem(ElderlyServiceItemUpdateReqVO reqVO) {
        ElderlyServiceItemDO dbItem = serviceItemMapper.selectById(reqVO.getId());
        if (dbItem == null) {
            throw ServiceExceptionUtil.exception(ELDERLY_SERVICE_ITEM_NOT_FOUND);
        }
        ElderlyServiceItemDO updateObj = ElderlyServiceItemConvert.INSTANCE.convert(reqVO);
        serviceItemMapper.updateById(updateObj);
    }

    @Override
    public void deleteServiceItem(Long id) {
        ElderlyServiceItemDO dbItem = serviceItemMapper.selectById(id);
        if (dbItem == null) {
            throw ServiceExceptionUtil.exception(ELDERLY_SERVICE_ITEM_NOT_FOUND);
        }
        serviceItemMapper.deleteById(id);
    }

    @Override
    public ElderlyServiceItemDO getServiceItem(Long id) {
        return serviceItemMapper.selectById(id);
    }

    @Override
    public PageResult<ElderlyServiceItemDO> getServiceItemPage(ElderlyServiceItemPageReqVO reqVO) {
        return serviceItemMapper.selectPage(reqVO);
    }

    @Override
    public List<ElderlyServiceItemDO> getSimpleServiceItemList() {
        return serviceItemMapper.selectSimpleList();
    }
}
