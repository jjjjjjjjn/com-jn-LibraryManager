package com.jn.service;

import com.jn.domain.Book;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ShowByType
 * @Package: com.jn.service
 * @Description:
 * @author：jn
 * @date： 2019/12/2 12:51
 */
public interface ShowByTypeService {
//  展示所有类型
    List<String> types();
//    展示某一类型所有书籍
    Map<String,Object> showByType(String type, int pageNo);


}
