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

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPoolMaxTotal() {
        return poolMaxTotal;
    }

    public void setPoolMaxTotal(String poolMaxTotal) {
        this.poolMaxTotal = poolMaxTotal;
    }

    public String getPoolMaxIdle() {
        return poolMaxIdle;
    }

    public void setPoolMaxIdle(String poolMaxIdle) {
        this.poolMaxIdle = poolMaxIdle;
    }

    public String getPoolMaxWait() {
        return poolMaxWait;
    }

    public void setPoolMaxWait(String poolMaxWait) {
        this.poolMaxWait = poolMaxWait;
    }
}
