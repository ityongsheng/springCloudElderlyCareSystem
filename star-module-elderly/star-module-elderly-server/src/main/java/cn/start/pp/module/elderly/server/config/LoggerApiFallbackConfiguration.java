package cn.start.pp.module.elderly.server.config;

import cn.start.pp.framework.common.biz.infra.logger.ApiAccessLogCommonApi;
import cn.start.pp.framework.common.biz.infra.logger.ApiErrorLogCommonApi;
import cn.start.pp.framework.common.biz.infra.logger.dto.ApiAccessLogCreateReqDTO;
import cn.start.pp.framework.common.biz.infra.logger.dto.ApiErrorLogCreateReqDTO;
import cn.start.pp.framework.common.pojo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 提供访问日志、错误日志接口的兜底实现，避免未引入实际 infra 服务导致启动失败。
 */
@Configuration
@Slf4j
public class LoggerApiFallbackConfiguration {

    @Bean
    @ConditionalOnMissingBean(ApiAccessLogCommonApi.class)
    public ApiAccessLogCommonApi apiAccessLogCommonApiFallback() {
        return new ApiAccessLogCommonApi() {
            @Override
            public CommonResult<Boolean> createApiAccessLog(ApiAccessLogCreateReqDTO createDTO) {
                log.debug("[apiAccessLogFallback] skip access log: {}", createDTO);
                return CommonResult.success(Boolean.TRUE);
            }
        };
    }

    @Bean
    @ConditionalOnMissingBean(ApiErrorLogCommonApi.class)
    public ApiErrorLogCommonApi apiErrorLogCommonApiFallback() {
        return new ApiErrorLogCommonApi() {
            @Override
            public CommonResult<Boolean> createApiErrorLog(ApiErrorLogCreateReqDTO createDTO) {
                log.warn("[apiErrorLogFallback] skip error log: {}", createDTO);
                return CommonResult.success(Boolean.TRUE);
            }
        };
    }
}
