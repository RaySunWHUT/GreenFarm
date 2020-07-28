package greenfarm.sun;

import greenfarm.sun.dao.ProductDao;
import greenfarm.sun.domain.Product;
import greenfarm.sun.domain.User;
import greenfarm.sun.email.EmailService;
import greenfarm.sun.serviceImpl.ProductServiceImpl;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SunApplicationTests {



    private static Logger logger = Logger.getLogger(SunApplicationTests.class);


    @Resource
    private EmailService emailService;

    @Resource
    private ProductDao productDao;

    @Test
    void contextLoads() {



    }


    @Test
    void halo() {

        Integer typeId = productDao.listTypeId("其它");

        logger.info(typeId);

    }

}
