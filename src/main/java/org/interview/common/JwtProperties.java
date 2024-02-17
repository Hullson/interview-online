package org.interview.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * @Author      : Hullson
 * @Date        : create in 2024-02-12
 * @Description : JWT配置信息配置类
 */
@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    private String iss;
    private String secret;
    private String tokenHeader;
    private String tokenPrefix;
    private String cacheKeyPrefix;
    private Duration loginValidateTime;
    private Duration loginRefreshLimit;
    private Duration rememberValidateTime;
    private Duration tokenExpireTime;
}
