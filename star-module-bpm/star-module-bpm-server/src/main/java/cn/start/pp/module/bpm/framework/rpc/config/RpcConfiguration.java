package cn.start.pp.module.bpm.framework.rpc.config;

import cn.start.pp.module.bpm.api.event.CrmContractStatusListener;
import cn.start.pp.module.bpm.api.event.CrmReceivableStatusListener;
import cn.start.pp.module.system.api.dept.DeptApi;
import cn.start.pp.module.system.api.dept.PostApi;
import cn.start.pp.module.system.api.dict.DictDataApi;
import cn.start.pp.module.system.api.permission.PermissionApi;
import cn.start.pp.module.system.api.permission.RoleApi;
import cn.start.pp.module.system.api.sms.SmsSendApi;
import cn.start.pp.module.system.api.user.AdminUserApi;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(value = "bpmRpcConfiguration", proxyBeanMethods = false)
@EnableFeignClients(clients = {RoleApi.class, DeptApi.class, PostApi.class, AdminUserApi.class, SmsSendApi.class, DictDataApi.class,
        PermissionApi.class})
public class RpcConfiguration {

    // ========== 特殊：解决微 star-cloud 微服务场景下，跨服务（进程）无法 Listener 的问题 ==========

    @Bean
    @ConditionalOnMissingBean(name = "crmReceivableStatusListener")
    public CrmReceivableStatusListener crmReceivableStatusListener() {
        return new CrmReceivableStatusListener();
    }

    @Bean
    @ConditionalOnMissingBean(name = "crmContractStatusListener")
    public CrmContractStatusListener crmContractStatusListener() {
        return new CrmContractStatusListener();
    }

}
