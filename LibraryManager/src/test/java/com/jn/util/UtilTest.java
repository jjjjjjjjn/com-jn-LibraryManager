package com.jn.util;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * @ClassName: UtilTest
 * @Package: com.jn.util
 * @Description:
 * @author：jn
 * @date： 2019/12/3 17:48
 */
public class UtilTest {
    String l_data = "2019-12-11";
    String r_data = "2019-12-12";

    @Test
    public void DateTest() throws IOException {
//        测试today方法
//        String a = DateUtil.today();
//        System.out.println(a);
//        测试dateCount方法
//        long a = 0;
//        try {
//            a = DateUtil.dateCount(l_data,r_data);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println(a);
//        FileInputStream inputStream =new FileInputStream("d:adc.txt");
//        byte [] bytes=new byte[10];
//        int len = inputStream.read(bytes);
//        while (len!=-1){
//            System.out.println(new String(bytes,0,len));
//            len = inputStream.read(bytes);
//
//        }

//        long a=jedis.lpush("uuid","a","22","asd","asdasd");
////        jedis.expire("uuid",10);
//        List<String> aaa=jedis.lrange("uuid",0,-1);
//        System.out.println(aaa+"    "+a);








    }
}
