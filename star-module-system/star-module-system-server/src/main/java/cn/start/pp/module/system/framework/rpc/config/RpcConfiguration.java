package cn.start.pp.module.system.framework.rpc.config;

import cn.start.pp.module.infra.api.config.ConfigApi;
import cn.start.pp.module.infra.api.file.FileApi;
import cn.start.pp.module.infra.api.websocket.WebSocketSenderApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(value = "systemRpcConfiguration", proxyBeanMethods = false)
@EnableFeignClients(clients = {FileApi.class, WebSocketSenderApi.class, ConfigApi.class})
public class RpcConfiguration {
}
