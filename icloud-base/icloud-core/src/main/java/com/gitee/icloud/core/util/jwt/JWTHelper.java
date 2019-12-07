package com.gitee.icloud.core.util.jwt;
import com.gitee.icloud.core.constants.CommonConstants;
import com.gitee.icloud.core.util.RsaKeyHelper;
import com.gitee.icloud.core.util.StringHelper;

import io.jsonwebtoken.*;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * @FileName JWTHelper.java
 * @Description: 
 *
 * @Date Nov 12, 2018 2:08:27 PM
 * @author Li.shangzhi
 * @version 1.0
 */
@Service
public class JWTHelper {
    @Autowired
    private RsaKeyHelper rsaKeyHelper;
    /**
     * 密钥加密token
     *
     * @param jwtInfo
     * @param priKey
     * @param expire
     * @return
     * @throws Exception
     */
    public String generateToken(IJWTInfo jwtInfo, byte priKey[], int expire) throws Exception {
        String compactJws = Jwts.builder()
                .setSubject(jwtInfo.getUniqueName())
                .claim(CommonConstants.JWT_KEY_USER_ID, jwtInfo.getId())
                .claim(CommonConstants.JWT_KEY_NAME, jwtInfo.getName())
                .claim(CommonConstants.JWT_KEY_EXPIRE, DateTime.now().plusSeconds(expire).toDate().getTime())
                .signWith(SignatureAlgorithm.RS256, rsaKeyHelper.getPrivateKey(priKey))
                .compact();
        return compactJws;
    }

    /**
     * 密钥加密token
     *
     * @param jwtInfo
     * @param priKey
     * @param expire
     * @return
     * @throws Exception
     */
    public String generateToken(IJWTInfo jwtInfo, byte priKey[], Date expire) throws Exception {
        String compactJws = Jwts.builder()
                .setSubject(jwtInfo.getUniqueName())
                .claim(CommonConstants.JWT_KEY_USER_ID, jwtInfo.getId())
                .claim(CommonConstants.JWT_KEY_NAME, jwtInfo.getName())
                .claim(CommonConstants.JWT_KEY_EXPIRE, expire.getTime())
                .signWith(SignatureAlgorithm.RS256, rsaKeyHelper.getPrivateKey(priKey))
                .compact();
        return compactJws;
    }

    /**
     * 密钥加密token
     *
     * @param jwtInfo
     * @param priKey
     * @param expire
     * @return
     * @throws Exception
     */
    public String generateToken(IJWTInfo jwtInfo, byte priKey[], Date expire,Map<String,String> otherInfo) throws Exception {
        JwtBuilder builder = Jwts.builder()
                .setSubject(jwtInfo.getUniqueName())
                .claim(CommonConstants.JWT_KEY_USER_ID, jwtInfo.getId())
                .claim(CommonConstants.JWT_KEY_NAME, jwtInfo.getName())
                .claim(CommonConstants.JWT_KEY_EXPIRE, expire.getTime());
        if(otherInfo!=null) {
            for (Map.Entry<String, String> entry : otherInfo.entrySet()) {
                builder.claim(entry.getKey(),entry.getValue());
            }
        }
        String compactJws = builder.signWith(SignatureAlgorithm.RS256, rsaKeyHelper.getPrivateKey(priKey))
                .compact();
        return compactJws;
    }

    /**
     * 公钥解析token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public Jws<Claims> parserToken(String token, byte[] pubKey) throws Exception {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(rsaKeyHelper.getPublicKey(pubKey)).parseClaimsJws(token);
        return claimsJws;
    }

    /**
     * 获取token中的用户信息
     *
     * @param token
     * @param pubKey
     * @return
     * @throws Exception
     */
    public IJWTInfo getInfoFromToken(String token, byte[] pubKey) throws Exception {
        Jws<Claims> claimsJws = parserToken(token, pubKey);
        Claims body = claimsJws.getBody();
        Map<String,String> otherInfo = new HashMap<String, String>();
        for(Map.Entry entry:body.entrySet()){
            if(Claims.SUBJECT.equals(entry.getKey())||CommonConstants.JWT_KEY_USER_ID.equals(entry.getKey())||CommonConstants.JWT_KEY_NAME.equals(entry.getKey())||CommonConstants.JWT_KEY_EXPIRE.equals(entry.getKey())){
                continue;
            }
            otherInfo.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()));
        }
        return new JWTInfo(body.getSubject(), StringHelper.getObjectValue(body.get(CommonConstants.JWT_KEY_USER_ID)), StringHelper.getObjectValue(body.get(CommonConstants.JWT_KEY_NAME)),new DateTime(body.get(CommonConstants.JWT_KEY_EXPIRE)).toDate(),otherInfo);
    }
}
