package com.jn.service;

import com.jn.dao.BookDao;
import com.jn.domain.Book;
import com.jn.service.impl.SearchBookServiceImpl;
import com.jn.service.impl.ShowByTypeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ShowByTypeServiceTest
 * @Package: com.jn.service
 * @Description:
 * @author：jn
 * @date： 2019/12/2 14:17
 */
public class ShowByTypeServiceTest {
    String config="spring.xml";
    ApplicationContext app = new ClassPathXmlApplicationContext(config);
    @Test
    public void loginTest(){

//        String names[] = app.getBeanDefinitionNames();
//        for(String name : names){
//            System.out.println("容器中定义对象名称:"+name);
//        }
//        测试 ShowByTypeServiceImpl中方法
//        ShowByTypeServiceImpl  sbs = (ShowByTypeServiceImpl)  app.getBean("showByTypeServiceImpl");
//        type方法：
//         List<String> a = sbs.types();
//        for (String s : a) {
//            System.out.println(s);
//
//        }
        SearchBookService  sbs = (SearchBookService)  app.getBean("searchBookServiceImpl");
        Book abook = new Book();
        abook.setCategory("哲学");

        System.out.println(abook);
       Map<String,Object> map =sbs.searchBook(abook,1);
        System.out.println(map);







    }
}
