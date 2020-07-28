package greenfarm.sun.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JWTUtil {

    // Token到期时间: 24小时
    private static final long EXPIRE_TIME = 60 * 60 * 24 * 1000;

//    private static final long EXPIRE_TIME = 5 * 1000;

    // 密钥
    private static final String SECRET = "Shiro+Token+Sun";

    /**
     * 生成token
     * @param userAccount
     * @return
     */
    public static String createToken(String userAccount) {

        try {

            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);

            Algorithm algorithm = Algorithm.HMAC256(SECRET);

            // 附带userAccount信息
            return JWT.create()
                    .withClaim("userAccount", userAccount)
                    // 到期时间
                    .withExpiresAt(date)
                    // 创建新的JWT, 使用HS256进行签名
                    .sign(algorithm);

        } catch (Exception e) {

            e.printStackTrace();

            return null;

        }

    }


    /**
     *
     * @param token 密钥
     * @param userAccount   用户账号
     * @return token是否验证通过
     */
    public static boolean verify(String token, String userAccount) {

        try {

            Algorithm algorithm = Algorithm.HMAC256(SECRET);

            // 在token中附带userAccount
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("userAccount", userAccount)
                    .build();

            // 验证token
            verifier.verify(token);

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

    }


    /**
     * 获得token中的信息, 无需secret解密也能获取
     * @param token
     * @return
     */
    public static String getUserAccount(String token) {

        try {

            DecodedJWT jwt = JWT.decode(token);

            String userAccount = jwt.getClaim("userAccount").asString();

            return userAccount;

        } catch (JWTDecodeException e) {

            e.printStackTrace();

            return null;

        }

    }

}


