package greenfarm.sun.email;

import greenfarm.sun.domain.User;

import java.util.List;

/**
 * 发送用户邮件服务
 */

public interface EmailService {

    public boolean sendJunkMail(List<User> userList);

}

