package com.jn.service.impl;

import com.jn.dao.BookDao;
import com.jn.dao.RecordDao;
import com.jn.dao.UserDao;
import com.jn.service.LendAndReturnService;
import com.jn.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: LendBookServiceImpl
 * @Package: com.jn.service.impl
 * @Description:
 * @author：jn
 * @date： 2019/12/3 15:42
 */
@Service
public class LendAndReturnServiceImpl implements LendAndReturnService {
    @Autowired
    UserDao userDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    RecordDao recordDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public int lendBook(long book_id, long user_id) {

        int flag = 0;
        if (bookDao.selectRest(book_id) < 1) {
            flag = 401;
            return flag;
        }
        if (userDao.getLnumber(user_id) >= 4) {
            flag = 402;
            return flag;
        }
        if (userDao.getMoney(user_id) <= 0) {
            flag = 403;
            return flag;
        }
        userDao.lockOne(user_id);
        bookDao.lockOne(book_id);
        flag += bookDao.updateOne(book_id);
        flag += userDao.setLnumber(user_id, 1);
        flag += recordDao.addOne(book_id, user_id, DateUtil.today());
        return flag;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public int returnBook(long re_id, long book_id, long use_id) {
        if (userDao.getLnumber(use_id) < 1) return 0;
        int flag = 0;
        bookDao.lockOne(book_id);
        recordDao.lockOne(re_id);
        userDao.lockOne(use_id);
        flag += bookDao.returnOne(book_id);
        String data = DateUtil.today();
        flag += recordDao.updateOne(re_id, data);
        userDao.lockOne(use_id);
        flag += userDao.setLnumber(use_id, -1);
        return flag;
    }
}
