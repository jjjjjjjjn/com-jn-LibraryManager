package com.jn.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: DateCount
 * @Package: com.jn.util
 * @Description:
 * @author：jn
 * @date： 2019/12/3 17:39
 */
public class DateUtil {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    //    返回今天日期的字符串
    public static String today() {
        Date now = new Date();
        String today = sdf.format(now);
        return today;
    }

    //    计算过了多少天
    public static long dateCount(String lend_date, String return_date) throws ParseException {
        Date l_date = sdf.parse(lend_date);
        Date r_date = sdf.parse(return_date);
        return (r_date.getTime() - l_date.getTime()) / (24 * 60 * 60 * 1000);
    }


}
