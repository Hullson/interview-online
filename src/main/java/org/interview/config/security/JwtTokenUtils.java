//package org.interview.config.security;
//
///**
// * @Author      : Hullson
// * @Date        : create in 2024-02-12
// * @Description : JWT token工具类
// */
//
//import com.google.common.collect.Maps;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import lombok.extern.slf4j.Slf4j;
//import org.interview.common.JwtProperties;
//import org.interview.common.SpringContextHolder;
//import org.interview.entity.sys.User;
//import org.interview.utils.GenerateID;
//import org.interview.utils.JedisUtils;
//
//import java.util.Date;
//import java.util.Map;
//
///**
// * 该类用于登录后的Token创建、刷新以及通过Token获取登录信息等
// * iss：JWT签发者
// * sub: 面相的用户
// * aud: 接收JWT的一方
// * iat: JWT签发时间
// * exp: JWT过期时间戳
// * nbf: 定义JWT可用时间
// * jti: JWT唯一身份标识，主要用来作为一次性token
// */
//@Slf4j
//public class JwtTokenUtils {
//    // 从配置文件中获取JWT配置信息
//    private static JwtProperties jwtProperties = SpringContextHolder.getBean(JwtProperties.class);
//
//    public static final String SESSION_KEY = "sessionId";
//    public static final String ISS = jwtProperties.getIss();
//    public static final String SECRET = jwtProperties.getSecret();;
//    public static final String TOKEN_HEADER = jwtProperties.getTokenHeader();
//    public static final String TOKEN_PREFIX = jwtProperties.getTokenPrefix();;
//    public static final String CACHE_KEY_PREFIX = jwtProperties.getCacheKeyPrefix();
//    public static final Long TOKEN_EXPIRE_TIME = jwtProperties.getTokenExpireTime().toMillis();
//    public static final Long LOGIN_VALIDATE_TIME = jwtProperties.getLoginValidateTime().toMillis();
//    public static final Long REMEMBER_VALIDATE_TIME = jwtProperties.getRememberValidateTime().toMillis();
//    public static final Long TOKEN_REFRESH_LIMIT = jwtProperties.getLoginRefreshLimit().toMillis();
//
//    /**
//     * 创建JWT token
//     * @param user          用户实体
//     * @param isRememberMe  是否"记住我"
//     * @return              token字符串
//     */
//    public static String createToken(User user, boolean isRememberMe) {
//        Map<String, Object> claims = Maps.newHashMap();
//        String sessionId = GenerateID.generateUUID();
//        claims.put(SESSION_KEY, sessionId);
//        String token = Jwts.builder()
//                .setId(GenerateID.generateUUID())
//                .signWith(SignatureAlgorithm.HS512, SECRET)
//                .setClaims(claims)
//                .setIssuer(ISS)
//                .setSubject(user.getUserName())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRE_TIME))
//                .compact();
//        Long expireation = (isRememberMe ? REMEMBER_VALIDATE_TIME : LOGIN_VALIDATE_TIME / 1000);
//        JedisUtils.setObject(CACHE_KEY_PREFIX + sessionId, user, expireation.intValue());
//        return token;
//    }
//
//    /**
//     * 从token中获取认证信息
//     * @param token     tokne字符串
//     * @return          Claims认证信息
//     */
//    public static Claims getClaimsFromToken(String token) {
//        Claims claims = null;
//        try {
//            claims = Jwts.parser()
//        }
//    }
//
//
//}
