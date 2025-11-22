package cn.start.pp.module.elderly.server.config;

import cn.start.pp.framework.security.config.AuthorizeRequestsCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;

/**
 * Elderly 模块的 Security 配置
 */
@Configuration
public class ElderlySecurityConfiguration {

    @Bean
    public AuthorizeRequestsCustomizer elderlyAuthorizeRequestsCustomizer() {
        return new AuthorizeRequestsCustomizer() {
            @Override
            public void customize(
                    AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry registry) {
                // 可以在这里添加 elderly 模块特定的权限配置
                // 例如：registry.requestMatchers(buildAdminApi("/elderly/**")).permitAll();
            }
        };
    }
}
