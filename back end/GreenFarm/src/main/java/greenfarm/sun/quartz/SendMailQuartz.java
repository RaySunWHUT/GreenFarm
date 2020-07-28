package greenfarm.sun.quartz;

import greenfarm.sun.dao.ProductDao;
import greenfarm.sun.domain.User;
import greenfarm.sun.email.EmailService;
import greenfarm.sun.service.ProductService;
import greenfarm.sun.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Component
@Configuration  // 加此注解的类相当于XML配置文件
@EnableScheduling   // 开启对计划任务的支持
public class SendMailQuartz {

    // 日志对象
    private Logger logger = LogManager.getLogger(SendMailQuartz.class);

    @Resource
    private ProductDao productDao;

    // 5秒执行一次
    @Scheduled(cron = "*/5 * *  * * * ")    // 定时任务, cron表达式为执行的时机
    public void reportCurrentByCron() {

        productDao.polling();

        logger.info("---------------------------------------------------------------");

    }

}
