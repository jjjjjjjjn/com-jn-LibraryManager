package com.jn.dao;

import com.jn.domain.Manager;

/**
 * @ClassName: ManagerDao
 * @Package: com.jn.dao
 * @Description:
 * @author：jn
 * @date： 2019/11/28 16:09
 */
public interface ManagerDao {
    Manager selectOne(String name,String password);

}
