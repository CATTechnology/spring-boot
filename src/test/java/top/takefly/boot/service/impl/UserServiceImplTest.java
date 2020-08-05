package top.takefly.boot.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import top.takefly.boot.bean.SimpleBean;
import top.takefly.boot.frame.properties.MyProperties;
import top.takefly.boot.service.UserService;

import javax.annotation.Resource;

/**
 * @description:
 * @author: lingfei_dai
 * @time: 2020/7/14 16:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("prod")
public class UserServiceImplTest {

    @Resource
    private SimpleBean simpleBean;

    @Resource
    private MyProperties myProperties;

    @Autowired
    private UserService userService;

    @Test
    public void listTest() {
        simpleBean.distributedLock();
        System.out.println(myProperties.toString());
//        System.out.println(userService.list());
    }
}
