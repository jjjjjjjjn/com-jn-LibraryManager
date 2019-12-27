package com.jn.service;

import com.jn.domain.Manager;
import com.jn.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.zip.CheckedOutputStream;

/**
 * @ClassName: LoginServicetest
 * @Package: com.jn.service
 * @Description:
 * @author：jn
 * @date： 2019/11/29 15:35
 */

public class LoginServiceTest {
    String config="spring.xml";
    ApplicationContext app = new ClassPathXmlApplicationContext(config);
    LoginService loginService = (LoginService)  app.getBean("loginServiceImpl");
    @Test
    public void loginTest(){
//        User user = (User)loginService.login("jiaonan","123456");
//        Manager manager = (Manager) loginService.login("焦","12345");
//        System.out.println(manager);






    }
}
