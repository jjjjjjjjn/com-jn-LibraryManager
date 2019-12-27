package com.jn.timer;

import com.jn.dao.RecordDao;
import com.jn.dao.UserDao;
import com.jn.domain.Record;
import com.jn.domain.User;
import com.jn.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Pay
 * @Package: com.jn.timer
 * @Description:
 * @author：jn
 * @date： 2019/12/5 14:31
 */
@Component
public class Pay {
    @Autowired
    RecordDao recordDao;
    @Autowired
    UserDao userDao;
    @Transactional(propagation= Propagation.REQUIRED , isolation = Isolation.DEFAULT)
    @Scheduled(cron ="0 0 0 * * ?")
//    实现定时检查借书超时并完成扣钱操作
    public  void pay() throws ParseException {


        List<User> userList =userDao.selectAll();
        for (User user : userList) {
            float paytoday=0;
            List<Record> recordList =recordDao.noReturn(user.getUser_id());

            for (Record record : recordList) {
                String today = DateUtil.today();
                long datecount=DateUtil.dateCount(record.getLend_data(),today);
                if(datecount>30)
                {
                    recordDao.lockOne(record.getRe_id());
                    recordDao.changeCost(record.getRe_id(),record.getCost()+(float)0.1);
                    paytoday+=0.1;

                }

            }
            userDao.lockOne(user.getUser_id());
            userDao.changeMoney(user.getUser_id(),user.getMoney()-paytoday);
        }

    }

}
