package com.jn.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: LendBookServiceTest
 * @Package: com.jn.service
 * @Description:
 * @author：jn
 * @date： 2019/12/3 19:15
 */
public class LendBookServiceTest {
    String config="spring.xml";
    ApplicationContext app = new ClassPathXmlApplicationContext(config);
    LendAndReturnService lendAndReturnService = (LendAndReturnService)  app.getBean("lendAndReturnServiceImpl");
    @Test
    public void lendtest()
    {
        int a = lendAndReturnService.lendBook(2,111);
        System.out.println(a);


    }
    @Test
    public void returntest()
    {
        int a = lendAndReturnService.returnBook(17,1,111);
        System.out.println(a);
    }
    @Test
    public void userupdate()
    {
        UserUpdateService userUpdateService = (UserUpdateService)  app.getBean("userUpdateServiceImpl");
        int a =userUpdateService.userUpdate("jiaonan","12345","jiaonan","123456");
        System.out.println(a);
    }


}
