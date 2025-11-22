package cn.start.pp.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目的启动类
 */
@SuppressWarnings("SpringComponentScan") // 忽略 IDEA 无法识别 ${star.info.base-package}
@SpringBootApplication(scanBasePackages = {"${star.info.base-package}.server", "${star.info.base-package}.module"},
        excludeName = {
            // RPC 相关
//            "org.springframework.cloud.openfeign.FeignAutoConfiguration",
//            "cn.start.pp.module.system.framework.rpc.config.RpcConfiguration"
        })
public class StarServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarServerApplication.class, args);
//        new SpringApplicationBuilder(StarServerApplication.class)
//                .applicationStartup(new BufferingApplicationStartup(20480))
//                .run(args);
    }

}
