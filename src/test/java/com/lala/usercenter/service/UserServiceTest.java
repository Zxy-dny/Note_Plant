package com.lala.usercenter.service;

import com.lala.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/*
 * 用户服务测试
 *
 * @author XiFeng
 */
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAdduser(){
        User user = new User();
        user.setUsername("DogLala");
        user.setUserAccount("123");
        user.setAvatarUrl("https://pic.cnblogs.com/avatar/3753035/20251227093756.png");
        user.setGender(0);
        user.setUserPassword("xxx");
        user.setPhone("123");
        user.setEmail("456");
        boolean res = userService.save(user);
        System.out.println(user.getId());
        assertTrue(res);    //  简化Assertions.assertEquals(true,res);

    }

    // 单元测试
    @Test
    void userRegister() {
        String userAccount = "lala";
        String userPassword = "";
        String checkPassword = "123456";
        String planetCode = "1";
        long res = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1,res);
        userAccount = "la";
        res = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1,res);
        userAccount = "lala";
        userPassword = "123456";
        res = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1,res);
        userAccount = "la la";
        userPassword = "12345678";
        res = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1,res);
        checkPassword = "123456789";
        res = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1,res);
        userAccount = "dogLala";
        checkPassword = "12345678";
        res = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1,res);
        userAccount = "lala";
        res = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1,res);
    }
}