package com.jn.dao;

import com.jn.domain.Book;
import com.jn.domain.Record;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: BookDao
 * @Package: com.jn.dao
 * @Description:
 * @author：jn
 * @date： 2019/12/2 12:03
 */
public interface BookDao {
//    获取所有种类
    List<String> selectAllType();
//  带分页的分类查询
    List<Book> selectByType(String type,int skipCount,int pageCount);
//    为selectByType分页提供提供总记录数
    int totalByType(String type);
//    带分页的模糊查询
    List<Book> selectSome(@Param("book")Book book, @Param("skipCount")int skipCount,  @Param("pageCount")int pageCount);
//    为selectsome分页提供提供总记录数
    int totalOfSearch(Book book);
//   指定书籍库存-1，借阅次数+1
     int updateOne(long book_id);
//    查询指定书籍库存量，为lend做准备
    int  selectRest(long book_id);
//    为指定书籍加锁,为lend做准备
    Book lockOne(long book_id);
//   指定书籍库存量+1
    int returnOne(long book_id);
}

