package greenfarm.sun.serviceImpl;

import com.alibaba.fastjson.JSONObject;

import greenfarm.sun.constants.Constants;
import greenfarm.sun.dao.UserDao;
import greenfarm.sun.domain.User;
import greenfarm.sun.service.UserService;
import greenfarm.sun.util.JSONUtil;
import greenfarm.sun.util.JWTUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    /**
     *      返回username字符串
     *      logger.info(token.getUsername());
     *
     *      返回username对象
     *      logger.info(token.getPrincipal());
     *
     *      返回password对象
     *      logger.info(token.getCredentials());
     *
     *      返回password字符数组
     *      logger.info(Arrays.toString(token.getPassword()));
     * @param jsonObject
     * @return
     */
    @Override
    public JSONObject login(JSONObject jsonObject) {

        String userAccount = jsonObject.getString("userAccount");
        String password = jsonObject.getString("password");

        User user = userDao.getUserByUserAccount(userAccount);

        String realPassword = user.getPassword();

        String salt = user.getSalt();

        String md5Password = getMd5Password(password, salt);

        JSONObject msg = null;

        if (!md5Password.equals(realPassword)) {

            msg = JSONUtil.errorJSON("incorrect");

        } else {

            String token = JWTUtil.createToken(userAccount);

            msg = JSONUtil.successJSON(token);

        }

        return msg;

    }


    @Override
    public JSONObject logout(JSONObject message) {

        JSONObject msg = null;

        if (message.get("message").equals("logout")) {

            Subject currentUser = SecurityUtils.getSubject();

            // 注销
            currentUser.logout();

            msg = JSONUtil.successJSON();

        }

        return msg;

    }


    @Override
    public JSONObject notLogin() {

        return JSONUtil.errorJSON("you haven't login.");

    }


    @Override
    public JSONObject updatePassword(JSONObject message) {

        String userAccount = message.getString("userAccount");

        User user = userDao.getUserByUserAccount(userAccount);

        //获取旧密码
        String oldPassword = message.getString("oldPassword");

        // 取出新密码
        String newPassword = message.getString("newPassword");

        // 取出盐值，用于后面的判断
        String salt = user.getSalt();

        // 对输入的原始密码进行加密，再与数据库中的进行匹配
        String md5Password = getMd5Password(oldPassword, salt);

        // 判断密码是否与数据库中匹配
        if(md5Password.equals(user.getPassword())) {

            // 对新的密码进行加密
            String newMd5Password = getMd5Password(newPassword, salt);

            JSONObject ok = new JSONObject();

            ok.put("password", newMd5Password);

            ok.put("userAccount", userAccount);

            Integer rows = userDao.updateUser(ok);

            // 修改失败
            if (rows != 1) {

                return JSONUtil.errorJSON("修改密码时发生未知错误! 修改密码失败! ");

            } else {    // 修改成功！

                return JSONUtil.successJSON();

            }

        } else {    // 原密码输入错误

            return JSONUtil.errorJSON("原密码输入错误！");

        }

    }


    @Override
    public JSONObject unauthorized(String message) {

        return JSONUtil.errorJSON("authority verify failed!");

    }


    @Override
    public JSONObject listUsers(JSONObject message) {

        String msg = message.getString("message");

        if (msg.equals("userList")) {

            List<JSONObject> users = userDao.listUsers();

            return JSONUtil.successJSON(users);

        } else {

            return JSONUtil.errorJSON(Constants.QUERY_FAILED);

        }

    }

    @Override
    public JSONObject listOneUser(JSONObject message) {

        String msg = message.getString("message");

        String userAccount = message.getString("userAccount");

        if (msg.equals("oneUser")) {

            JSONObject user = userDao.listOneUser(userAccount);

            return JSONUtil.successJSON(user);

        } else {

            return JSONUtil.errorJSON(Constants.QUERY_FAILED);

        }

    }


    @Override
    public JSONObject register(JSONObject object) throws DuplicateKeyException {

        User user = userDao.getUserByUserAccount(object.getString("userAccount"));

        // 获取前端界面输入的密码作为原始密码
        String srcPassword = object.getString("password");

        String userAccount = object.getString("userAccount");

        if (user == null) {

            if (srcPassword == null || userAccount == null) {

                return JSONUtil.errorJSON("用户名或密码不能为空！");

            } else {    // 用户名和密码皆不为空

                // 处理密码加密
                // 1. 根据UUID生成盐值，这里的盐值统一大写
                String salt = UUID.randomUUID().toString().toUpperCase();

                // 3. 用MD5对密码进行加密, 获得新密码
                String md5Password = getMd5Password(srcPassword, salt);

                // 4. 将加密后的密码存放到数据库中
                object.put("password", md5Password);

                // 5. 将盐值存放到数据库中
                object.put("salt", salt);

                object.put("roleId", "3");

                userDao.saveUser(object);

                return JSONUtil.successJSON();

            }

        } else {

            return JSONUtil.errorJSON("注册用户失败! 用户名 \'" + object.getString("userAccount") + "\' 已存在!");

        }

    }


    /**
     * 对原始密码和盐值执行MD5加密
     * @param srcPassword 原始密码
     * @param salt 盐值
     * @return 加密后的密码
     */
    private String getMd5Password(String srcPassword, String salt) {

        String src = salt + srcPassword + salt;

        for (int i = 0; i < 5; i++) {

            src = DigestUtils.md5DigestAsHex(src.getBytes()).toUpperCase();

        }

        return src;

    }


    @Override
    public JSONObject updateUser(JSONObject jsonObject) {

        Integer result = userDao.updateUser(jsonObject);

        if (result != 1) {

            return JSONUtil.errorJSON("删除异常!");

        } else {

            return JSONUtil.successJSON();

        }

    }



}

