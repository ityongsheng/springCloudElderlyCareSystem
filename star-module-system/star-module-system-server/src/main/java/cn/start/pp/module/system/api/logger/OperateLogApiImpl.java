package cn.start.pp.module.system.api.logger;

import cn.start.pp.framework.common.pojo.CommonResult;
import cn.start.pp.framework.common.pojo.PageResult;
import cn.start.pp.framework.common.util.object.BeanUtils;
import cn.start.pp.framework.common.biz.system.logger.dto.OperateLogCreateReqDTO;
import cn.start.pp.module.system.api.logger.dto.OperateLogPageReqDTO;
import cn.start.pp.module.system.api.logger.dto.OperateLogRespDTO;
import cn.start.pp.module.system.dal.dataobject.logger.OperateLogDO;
import cn.start.pp.module.system.service.logger.OperateLogService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Primary;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import static cn.start.pp.framework.common.pojo.CommonResult.success;

@RestController // 提供 RESTful API 接口，给 Feign 调用
@Validated
@Primary // 由于 OperateLogCommonApi 的存在，必须声明为 @Primary Bean
public class OperateLogApiImpl implements OperateLogApi {

    @Resource
    private OperateLogService operateLogService;

    @Override
    public CommonResult<Boolean> createOperateLog(OperateLogCreateReqDTO createReqDTO) {
        operateLogService.createOperateLog(createReqDTO);
        return success(true);
    }

    @Override
    public CommonResult<PageResult<OperateLogRespDTO>> getOperateLogPage(OperateLogPageReqDTO pageReqDTO) {
        PageResult<OperateLogDO> operateLogPage = operateLogService.getOperateLogPage(pageReqDTO);
        return success(BeanUtils.toBean(operateLogPage, OperateLogRespDTO.class));
    }

}
