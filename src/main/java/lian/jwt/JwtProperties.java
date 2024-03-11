package lian.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * JWT配置类，读取Application.yml中的配置
 *
 * @author AdminMall
 *
 */
@Component
public class JwtProperties {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader; // JWT存储的请求头
    @Value("${jwt.secret}")
    private String secret; // jwt加解密使用的密钥
    @Value("${jwt.expiration}")
    private long expiration; // JWT的超时时间
    @Value("${jwt.tokenHead}")
    private String tokenHead; // JWT负载中拿到的开头

    public String getTokenHeader() {
        return tokenHeader;
    }

    public void setTokenHeader(String tokenHeader) {
        this.tokenHeader = tokenHeader;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getExpiration() {
        return expiration;
    }

    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }

    public String getTokenHead() {
        return tokenHead;
    }

    public void setTokenHead(String tokenHead) {
        this.tokenHead = tokenHead;
    }

}

