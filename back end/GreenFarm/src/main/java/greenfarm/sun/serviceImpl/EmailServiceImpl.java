package greenfarm.sun.serviceImpl;

import greenfarm.sun.domain.User;
import greenfarm.sun.email.EmailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.List;


@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    JavaMailSender mailSender;

    @Value("${spring.mail.username}")   // 将application.properties配置文件中的配置设置到属性中
    private String from;

    private static final Logger logger = LogManager.getLogger(EmailServiceImpl.class);

    @Override
    public boolean sendJunkMail(List<User> userList) {

        try {

            if (userList == null || userList.size() <= 0) {

                return Boolean.FALSE;

            }

            for (User user : userList) {

                MimeMessage mimeMessage = this.mailSender.createMimeMessage();

                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);

                // 发送方
                message.setFrom(from);

                // 邮件主题
                message.setSubject("生态农场, 找回密码");

                // 接收方
                message.setTo("582373673@qq.com");

                // 内容
                message.setText(user.getUserAccount() + "：I only do three things every day: eat, sleep, play zyf. hhhhhh!!!\n");

                // 发送邮件
                this.mailSender.send(mimeMessage);

            }

        } catch (Exception ex) {

            logger.error("sendJunMail error and user = %s", userList, ex);

            return Boolean.FALSE;

        }

        return Boolean.TRUE;

    }

}
