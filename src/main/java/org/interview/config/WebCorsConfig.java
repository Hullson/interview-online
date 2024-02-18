package org.interview.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author      : Hullson
 * @Date        : created on 2024-02-18
 * @Description : 配置前后端跨域
 */

@Configuration
public class WebCorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // 配置是否允许发送身份认证信息（cookie、session）
                .allowCredentials(true)
                // 配置放行的请求源
                .allowedOriginPatterns("*")
                // 配置放行的请求方式
                .allowedMethods(new String[]{"GET", "POST", "PUT", "DELETE"})
                // 配置放行的请求头
                .allowedHeaders("*")
                // 配置放行的请求头携带属性
                .exposedHeaders("*");
    }
}
