package com.fanzs.secondskill.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by fzs on 2018/4/1.
 */

@Component
@ConfigurationProperties(prefix="redis")
public class RedisConnfig {
    private String host;
    private String port;
    private String timeout;
    private String password;
    private String poolMaxTotal;
    private String poolMaxIdle;
    private String poolMaxWait;


}
