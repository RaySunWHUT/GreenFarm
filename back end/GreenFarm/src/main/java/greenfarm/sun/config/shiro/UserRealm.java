package greenfarm.sun.config.shiro;

import com.alibaba.fastjson.JSONObject;
import greenfarm.sun.dao.UserDao;
import greenfarm.sun.util.JWTUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;


public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserDao userDao;

    private static Logger logger = Logger.getLogger(UserRealm.class);

    /**
     * Permission Verify：授权
     * @param principal
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {

//        System.out.println("------------- Permission Verify ------------");

        String userAccount = JWTUtil.getUserAccount(principal.toString());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        JSONObject role = userDao.getRoleByUserAccount(userAccount);

        Set<String> roleSet = new HashSet<String>();

        // 需要将 role 封装到 roleSet 作为 info.setRoles() 的参数
        roleSet.add((String) role.get("roleName"));

        logger.info(role);


        // 设置该用户拥有的角色
        info.setRoles(roleSet);

        return info;

    }


    /**
     * 必须重写
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {

        return token instanceof JWTToken;

    }


    /**
     * Identity Verify: 身份认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {

//        logger.info("-------------- Identity Verify ----------------");

        String token = (String) authenticationToken.getCredentials();

//        logger.info("token: " + token);

        String userAccount = JWTUtil.getUserAccount(token);


        if (userAccount == null || !JWTUtil.verify(token, userAccount)) {

            throw new AuthenticationException("verify token failed!");

        }

        String password = userDao.getUserByUserAccount(userAccount).getPassword();

        if (password == null) {

            throw new AuthenticationException("user is not exist!");

        }

        // 5.返回身份处理对象
        return new SimpleAuthenticationInfo(token, token, "SunRealm");

    }

}

