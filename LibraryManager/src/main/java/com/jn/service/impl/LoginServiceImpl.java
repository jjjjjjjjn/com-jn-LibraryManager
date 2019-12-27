package com.jn.service.impl;

import com.jn.dao.ManagerDao;
import com.jn.dao.UserDao;
import com.jn.domain.Manager;
import com.jn.domain.User;
import com.jn.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ManagerServiceImpl
 * @Package: com.jn.service.impl
 * @Description:
 * @author：jn
 * @date： 2019/11/29 10:32
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    ManagerDao managerDao;
    @Autowired
    UserDao userDao;

    @Override
    public Map<String, Object> login(String name, String password) {
        User user = userDao.selectOne(name, password);
        Manager manager = managerDao.selectOne(name, password);
        Map<String, Object> map = new HashMap<>();
        if (user != null) {
            map.put("user", user);
            return map;
        }
        if (manager != null) {
            map.put("manager", manager);
            return map;
        }
        return null;
    }

}
