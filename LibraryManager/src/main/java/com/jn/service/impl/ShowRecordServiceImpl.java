package com.jn.service.impl;

import com.jn.dao.RecordDao;
import com.jn.domain.Record;
import com.jn.service.ShowRecordService;
import com.jn.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ShowRecordImpl
 * @Package: com.jn.service.impl
 * @Description:
 * @author：jn
 * @date： 2019/12/4 13:40
 */
@Service
public class ShowRecordServiceImpl implements ShowRecordService {
    @Autowired
    RecordDao recordDao;


    @Override
    public Map<String, Object> showRecord(long user_id, int pageNo) {
        Map<String, Object> recordmap = new HashMap<>();
        int total = recordDao.total(user_id);
        Page page = new Page(pageNo, total);
        List<Record> records = recordDao.selectByUser(user_id, page.getSkipCount(), page.pageCount);
        recordmap.put("records", records);
        recordmap.put("p1", page);

        return recordmap;
    }
}
