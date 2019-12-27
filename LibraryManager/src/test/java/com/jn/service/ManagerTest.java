package com.jn.service;

import com.jn.dao.BookDao;
import com.jn.dao.RecordDao;
import com.jn.dao.UserDao;
import com.jn.domain.Record;
import com.jn.domain.User;
import com.jn.util.DateUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ManagerTest
 * @Package: com.jn.service
 * @Description:
 * @author：jn
 * @date： 2019/12/5 9:35
 */
public class ManagerTest {
    String config="spring.xml";
    ApplicationContext app = new ClassPathXmlApplicationContext(config);
    @Test
    public  void managertest() throws ParseException {
//        String names[] = app.getBeanDefinitionNames();
//        for(String name : names){
//            System.out.println("容器中定义对象名称:"+name);
//        }
//        测试UserUpdateService
        UserUpdateService userUpdateService = (UserUpdateService) app.getBean("userUpdateServiceImpl");
         User user1 = userUpdateService.userSearch(-1,"jiaoting");
        System.out.println(user1);
//
//        int a = userUpdateService.deleteUser(user1);
//        System.out.println(a);


//        User user0=new User();
//        user0.setUser_id(111);
//        User user1=new User();
//        user1.setUser_name("jiaonan22");
//        user1.setUser_password("123456");
//        user1.setMoney((float)100);
//        user1.setLnumber(2);
//        int a=userUpdateService.changeuser(user0,user1);
//        System.out.println(a);
//         测试定时任务
//        RecordDao recordDao=(RecordDao) app.getBean("recordDao");
//        UserDao userDao=(UserDao) app.getBean("userDao");
//        List<User> userList =userDao.selectall();
//        int flag = 0;
//        for (User user : userList) {
//            float paytoday=0;
//            List<Record> recordList =recordDao.selectByUser(user.getUser_id());
//            List<String> datelist=new ArrayList<>();
//            for (Record record : recordList) {
//                datelist.add(record.getLend_data());
//                String today = DateUtil.today();
//                long datecount=DateUtil.dateCount(record.getLend_data(),today);
//                if(datecount>30)
//                {
//                    recordDao.changecost(record.getRe_id(),record.getCost()+(float)0.1);
//                    paytoday+=0.1;
//
//                }
//
//            }
//            userDao.changemoney(user.getUser_id(),user.getMoney()-paytoday);
//        }



    }
}
