package com.jn.service;

import com.jn.domain.Record;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ShowRecord
 * @Package: com.jn.service
 * @Description:
 * @author：jn
 * @date： 2019/12/4 13:38
 */
public interface ShowRecordService {
//    展示借阅记录
    Map<String, Object> showRecord(long user_id, int pageNo);
}
