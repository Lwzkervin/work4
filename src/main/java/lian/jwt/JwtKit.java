package lian.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import lian.jwt.*;

import lian.user.*;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 *
 * JWT工具类
 *
 * @author MAll
 *
 *
 */
public class JwtKit {
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 生成Token
     *
     * @param user 自定义要存储的用户对象信息
     * @return
     */
    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<String, Object>();//有疑问
        claims.put("name", user.getUsername());
        claims.put("createdate", new Date());
        claims.put("id", System.currentTimeMillis());

        return Jwts.builder().addClaims(claims) // 要存储的数据
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpiration())) // 过期时间
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret()) // 加密算法和密钥
                .compact(); // 打包返回 3部分
    }

    /**
     * 校验Token是否合法
     *
     * @param token 要校验的Token
     * @return
     */
    public Claims parseJwtToken(String token) {
        Claims claims = null;
        claims = Jwts.parser().setSigningKey(jwtProperties.getSecret())// 根据哪个密钥解密
                .parseClaimsJws(token) // 设置要解析的Token
                .getBody();
        return claims;
    }
}

