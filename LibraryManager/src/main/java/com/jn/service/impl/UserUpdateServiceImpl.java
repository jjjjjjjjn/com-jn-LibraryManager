package com.jn.service.impl;

import com.jn.dao.UserDao;
import com.jn.domain.User;
import com.jn.service.UserUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: UserUpdateServiceImpl
 * @Package: com.jn.service.impl
 * @Description:
 * @author：jn
 * @date： 2019/12/4 18:07
 */
@Service
public class UserUpdateServiceImpl implements UserUpdateService {

    @Autowired
    UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public int userUpdate(String oldname, String oldpassword, String newname, String newpassword) {
        User user2 = userDao.selectOne(newname, newpassword);
        if (user2 != null) return 401;
        User user1 = userDao.selectOne(oldname, oldpassword);
        if (user1 == null) return 401;
        userDao.lockOne(user1.getUser_id());
        int flag = userDao.updateOne(user1.getUser_id(), newname, newpassword);
        return flag;
    }

    public User userSearch(long user_id, String user_name) {

        return userDao.selectUser(user_id, user_name);
    }

    public int addUser(User user) {
        int flag = 0;
        User user1 = userDao.selectOne(user.getUser_name(), user.getUser_password());
        if (user1 != null) return 401;
        flag += userDao.addUser(user);
        return flag;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public int deleteUser(User user) {
        int flag = 0;

        int money = userDao.getMoney(user.getUser_id());
        if (money <= 0) return 401;
        userDao.lockOne(user.getUser_id());
        flag += userDao.deleteUser(user.getUser_id());
        return flag;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public int changeUser(User olduser, User newuser) {
        int flag = 0;
        userDao.lockOne(olduser.getUser_id());
        User user2 = userDao.selectOne(newuser.getUser_name(), newuser.getUser_password());
        boolean bool1 = !(olduser.getUser_name().equals(newuser.getUser_name()));
        boolean bool2 = !(olduser.getUser_password().equals(newuser.getUser_password()));
        if ((user2 != null) && (bool1 || bool2)) return 401;
        newuser.setUser_id(olduser.getUser_id());
        System.out.println(newuser);
        flag += userDao.changeUser(newuser);
        return flag;
    }


}
