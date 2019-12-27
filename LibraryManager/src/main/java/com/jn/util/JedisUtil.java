package com.jn.util;


import com.jn.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: JedisUtil
 * @Package: com.jn.util
 * @Description:
 * @author：jn
 * @date： 2019/12/12 17:43
 */
@Component
public class JedisUtil {
    @Autowired
    LoginService loginService;
    private static final Jedis JEDIS = new Jedis("47.98.146.107", 6379);

    static {
        JEDIS.auth("15319902234.jn");
    }

    //    在redis中注册用户
    public long putPerson(String uuid, String name, String password) {
        long res = JEDIS.rpush(uuid, name, password);
        JEDIS.expire(uuid, 60 * 30);
        return res;

    }

    //    从redis中取出用户
    public Map<String, Object> getPerson(String uuid) {
        List<String> lists = JEDIS.lrange(uuid, 0, -1);
        Map<String, Object> map = loginService.login(lists.get(0), lists.get(1));
        return map;
    }

    public static boolean ifLogin(String uuid) {
        return JEDIS.exists(uuid);
    }

}
