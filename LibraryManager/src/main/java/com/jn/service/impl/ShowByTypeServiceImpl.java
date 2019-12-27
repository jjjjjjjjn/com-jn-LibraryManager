package com.jn.service.impl;

import com.jn.dao.BookDao;
import com.jn.domain.Book;
import com.jn.service.ShowByTypeService;
import com.jn.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ShowByTypeImpl
 * @Package: com.jn.service.impl
 * @Description:
 * @author：jn
 * @date： 2019/12/2 13:12
 */
@Service
public class ShowByTypeServiceImpl implements ShowByTypeService {
    @Autowired
    BookDao bookDao;

    @Override
    public List<String> types() {

        return bookDao.selectAllType();
    }

    @Override
    public Map<String, Object> showByType(String type, int pageNo) {
        int total = bookDao.totalByType(type);
        Page page = new Page(pageNo, total);
        List<Book> books = bookDao.selectByType(type, page.getSkipCount(), page.pageCount);
        Map<String, Object> bookmap = new HashMap<>();
        bookmap.put("books", books);
        bookmap.put("p1", page);


        return bookmap;
    }

}
