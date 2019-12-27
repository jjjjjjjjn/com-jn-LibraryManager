package com.jn.dao;

import com.jn.domain.Book;
import com.jn.domain.Record;

import java.util.List;

/**
 * @ClassName: RecordDao
 * @Package: com.jn.dao
 * @Description:
 * @author：jn
 * @date： 2019/12/3 12:30
 */
public interface RecordDao {
    //   借阅记录+1
    int addOne(long book_id, long user_id,String data);
//    展示借阅记录记录
    List<Record> selectByUser(long user_id,int pageSkip,int pageCount);
//        展示已借书籍记录
    List<Record> noReturn(long user_id);
//    指定借书记录添加归还日期
    int updateOne(long re_id,String data);
//    为指定记录加锁
    Record lockOne(long re_id);
//    指定id修改未还记录中的cost
    int changeCost(long re_id,float cost);
//    获得指定用户总条数
    int total(long user_id);





}
