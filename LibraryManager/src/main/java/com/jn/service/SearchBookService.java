package com.jn.service;

import com.jn.domain.Book;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: SearchBookService
 * @Package: com.jn.service
 * @Description:
 * @author：jn
 * @date： 2019/12/2 20:35
 */

public interface SearchBookService {
//    搜索书籍
    Map<String,Object> searchBook(Book book, int pageNo);
}
