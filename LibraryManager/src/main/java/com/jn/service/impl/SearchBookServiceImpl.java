package com.jn.service.impl;

import com.jn.dao.BookDao;
import com.jn.domain.Book;
import com.jn.service.SearchBookService;
import com.jn.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: SearchBookServiceImpl
 * @Package: com.jn.service.impl
 * @Description:
 * @author：jn
 * @date： 2019/12/2 20:39
 */
@Service
public class SearchBookServiceImpl implements SearchBookService {

    @Autowired
    BookDao bookDao;

    @Override
    public Map<String, Object> searchBook(Book book, int pageNo) {

        int total = bookDao.totalOfSearch(book);
        Page page = new Page(pageNo, total);
        List<Book> books = bookDao.selectSome(book, page.getSkipCount(), page.pageCount);
        Map<String, Object> bookmap = new HashMap<>();
        bookmap.put("books", books);
        bookmap.put("p1", page);

        return bookmap;
    }
}
