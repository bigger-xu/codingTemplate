package com.coding.temp;

import com.coding.temp.entity.User;
import com.coding.temp.service.UserService;
import com.coding.temp.utils.Md5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TempApplicationTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(TempApplicationTests.class);
    @Autowired
    private UserService userService;
    @Test
    public void contextLoads() {
//        User user = new User();
//        user.setNickName("大脑腐");
//        user.setPassword(Md5Util.compute("123456"));
//        user.setUserName("admin");
//        user.setCreateTime(new Date());
//        userService.insert(user);
//        LOGGER.info("用户添加成功,{}", user.toString());
    }

}
