package com.jn.util;

import com.jn.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import java.util.Map;

/**
 * @ClassName: CookieUtil
 * @Package: com.jn.util
 * @Description:
 * @author：jn
 * @date： 2019/12/8 18:29
 */
@Component
public class CookieUtil {
    @Autowired
    JedisUtil jedisUtil;
//    根据cookie中的uuid在redis里取得用户
    public  User getUser(Cookie[] cookies)
    {
        String uuid=null;

        for (Cookie cookie : cookies) {

            if (cookie.getName().equals("uuid"))
            {
                uuid=cookie.getValue();
            }

        }
        Map<String,Object> map=jedisUtil.getPerson(uuid);
        User user=(User) map.get("user");
        return  user;

    }

}
